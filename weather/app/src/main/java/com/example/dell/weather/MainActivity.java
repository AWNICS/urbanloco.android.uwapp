package com.example.dell.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnstart;
   // private Button btnwthr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnstart = (Button) findViewById(R.id.btnMaps);
        btnstart.setOnClickListener(this);
//        btnwthr =(Button)findViewById(R.id.btnWeather);
//        btnwthr.setOnClickListener(this);
//        WeatherJsonParsing jsonParsing = new WeatherJsonParsing();
//        jsonParsing.execute();
//GetRawData theRawData = new GetRawData("http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=9c64cb2fc2376949721b91cc8abb76a4");
//        theRawData.execute();

//

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnMaps:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                break;

//            case R.id.btnWeather:
//                intent = new Intent(MainActivity.this,weatherActivity.class);
//                break;

            default:
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
