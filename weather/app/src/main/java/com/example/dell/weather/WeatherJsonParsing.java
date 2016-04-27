package com.example.dell.weather;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.util.Log;

import com.example.dell.weather.Details.WeatherDetails;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 23-04-2016.
 */
public class WeatherJsonParsing extends GetRawData  {
    private String LOG_TAG = WeatherJsonParsing.class.getSimpleName();
    private Uri destinationUri ;
    private WeatherDetails mWeatherDetails;
    private Context mContext;

    public WeatherDetails getWeatherDetails() {
        return mWeatherDetails;
    }

    public WeatherJsonParsing(Context context) {
        super(null);
        CreateandUpdateUri();
        mContext = context;

    }

    public boolean CreateandUpdateUri(){
        final String Weather_uri= "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139";
        final  String Key = "APPID";
        destinationUri = Uri.parse(Weather_uri).buildUpon().appendQueryParameter(Key, "9c64cb2fc2376949721b91cc8abb76a4").build();
        return destinationUri != null;
    }
    public void execute(){
        super.setmRawUrl(destinationUri.toString());
        WeatherJsonData weatherJsonData = new WeatherJsonData();
        Log.v(LOG_TAG, "built uri =" + destinationUri.toString());
        weatherJsonData.execute(destinationUri.toString());
    }




    public void processResult(){

        if(getmDownloadStatus() != DownloadStatus.OK){
            Log.d(LOG_TAG, "Error Downloading Raw File");
            return ;
        }

        try {

            mWeatherDetails = new WeatherDetails();
            JSONObject jsonData = new JSONObject(getmData());
            JSONObject coordObj = getObject("coord",jsonData);
            mWeatherDetails.setLat(getString("lat", coordObj));
            mWeatherDetails.setLon(getString("lon", coordObj));

            JSONObject sysObj = getObject("sys", jsonData);
            mWeatherDetails.setCountry(getString("country", sysObj));

            JSONObject  mainObj  = getObject("main",jsonData);
            mWeatherDetails.setTemp(getString("temp", mainObj));
            mWeatherDetails.setTemp_max(getString("temp_max", mainObj));
            mWeatherDetails.setTemp_min(getString("temp_min", mainObj));

            Message msg = weatherActivity.getmHandler().obtainMessage();
            msg.obj = mWeatherDetails;
            msg.arg1 = weatherActivity.UPDATE_UI;
            weatherActivity.getmHandler().sendMessage(msg);


        }catch(JSONException jsone){
            jsone.printStackTrace();
            Log.e(LOG_TAG,"Error processing jsone data");
        }
    }


    public class WeatherJsonData extends DownloadRawData {
        @Override
        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }


        @Override
        protected String doInBackground(String... params) {
            return super.doInBackground(params);
        }


    }

    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }
    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

}