package com.example.dell.weather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Dell on 27-04-2016.
 */
public class CheckConnectivity {
    ConnectivityManager mConnectivityManager;
    NetworkInfo wifiInfo, mobileInfo;

    public Boolean checkNow(Context con){

        try{
            mConnectivityManager = (ConnectivityManager)con.getSystemService((Context.CONNECTIVITY_SERVICE));
            wifiInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobileInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if(wifiInfo.isConnected() || mobileInfo.isConnected()){
                return true;
            }

        }
        catch(Exception e){
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
        }

        return false;
    }
}
