package com.example.dell.weather;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.weather.Details.WeatherDetails;

public class weatherActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.butnMap:
                intent = new Intent(weatherActivity.this, MapsActivity.class);
                break;

            default:
        }
        if(intent != null){
            startActivity(intent);
        }
    }

    public final static int UPDATE_UI = 2;
    private static WeatherDetails mWeatherDetails=null;
    private Button btnGoogleMap;

    private static final Handler mHandler = new Handler(){public void handleMessage(Message msg) {
        final int what = msg.arg1;
        mWeatherDetails = (WeatherDetails)msg.obj;
        switch(what) {
            case UPDATE_UI: updateUI(); break;

        }
    }};

    public static Handler getmHandler() {
        return mHandler;
    }

    private static TextView Latitude;
    private static TextView Longitude;
    private static TextView Temperature;
    private static TextView tempMax;
    private static TextView Temp_min;
    private static TextView Country;
    private String LOG_TAG = weatherActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Latitude = (TextView) findViewById(R.id.latitude);
        Longitude = (TextView) findViewById(R.id.longitude);
        Temperature = (TextView) findViewById(R.id.temperature);
        tempMax = (TextView) findViewById(R.id.temp_max);
        Temp_min = (TextView) findViewById(R.id.temp_min);
        Country = (TextView) findViewById(R.id.country);
        btnGoogleMap = (Button)findViewById(R.id.butnMap);
        btnGoogleMap.setOnClickListener(this);
        WeatherJsonParsing jsonParsing = new WeatherJsonParsing(this);

        jsonParsing.execute();


    }

    public static void updateUI(){
        Latitude.setText("Latitude  " + mWeatherDetails.getLat());
        Longitude.setText("Longitude " +mWeatherDetails.getLat());
        Temperature.setText("Temperature " + mWeatherDetails.getTemp());
        tempMax.setText("Temp_max " + mWeatherDetails.getTemp_max());
        Temp_min.setText("Temp_min " + mWeatherDetails.getTemp_min());
        Country.setText("Country " + mWeatherDetails.getCountry());
    }

//    public class DownloadWeather extends AsyncTask<String, Void, WeatherDetails > {
//        @Override
//        protected WeatherDetails doInBackground(String... params) {
//            WeatherDetails weatherDetails = new WeatherDetails();
//            WeatherJsonParsing jsonParsing = new WeatherJsonParsing();
//            jsonParsing.execute();
//            return weatherDetails;
//        }
//
//        @Override
//        protected void onPostExecute(WeatherDetails weatherDetails) {
//            super.onPostExecute(weatherDetails);
//            Latitude.setText(weatherDetails.getLat());
//            Longitude.setText(weatherDetails.getLat());
//            Temperature.setText("Temperature " + weatherDetails.getTemp());
//            Temp_max.setText("Temp_max " + weatherDetails.getTemp_max());
//            Temp_min.setText("Temp_min " + weatherDetails.getTemp_min());
//            Country.setText("Country " + weatherDetails.getCountry());
//        }
//
//
//    }

}
