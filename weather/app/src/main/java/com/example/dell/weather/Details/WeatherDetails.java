package com.example.dell.weather.Details;

import java.io.Serializable;

/**
 * Created by Dell on 25-04-2016.
 */
public class WeatherDetails implements Serializable {
//    private String longitude;
//    private String latitude;

    private String lat;
    private String lon;
    private String temp_min;
    private String temp_max;
    private String temp;
    private String country;

//    public WeatherDetails(String lat, String lon, String temp_min, String temp_max, String temp, String country) {
//        this.lat = lat;
//        this.lon = lon;
//        this.temp_min = temp_min;
//        this.temp_max = temp_max;
//        this.temp = temp;
//        this.country = country;
//    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", temp_min='" + temp_min + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", temp='" + temp + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}