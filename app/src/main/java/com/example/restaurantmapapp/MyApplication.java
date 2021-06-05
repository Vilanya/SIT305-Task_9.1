package com.example.restaurantmapapp;

import android.app.Application;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MyApplication extends Application {
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        //Parse SDK stuff goes here
//    }

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<LatLng> locations = new ArrayList<>();

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<LatLng> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<LatLng> locations) {
        this.locations = locations;
    }

}
