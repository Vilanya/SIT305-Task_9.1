package com.example.restaurantmapapp;

import android.app.Application;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> marker_list = new ArrayList<String>();
    private ArrayList<LatLng> loc_list = new ArrayList<LatLng>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button add_button = (Button)findViewById(R.id.buttonAdd);
//        Button show_button = (Button)findViewById(R.id.buttonShow);

        loc_list = ((MyApplication) getApplication()).getLocations();
        marker_list = ((MyApplication) getApplication()).getNames();

        String current_name = getIntent().getStringExtra("marker");
//        Toast.makeText(MainActivity.this, current_name, Toast.LENGTH_SHORT).show();
        marker_list.add(current_name);
        LatLng current_location = getIntent().getParcelableExtra("location");
        loc_list.add(current_location);

        ((MyApplication) getApplication()).setNames(marker_list);
        ((MyApplication) getApplication()).setLocations(loc_list);

    }

    public void onClickAdd(View v){
        Intent intent = new Intent(MainActivity.this, AddRestaurantActivity.class);
        startActivity(intent);
    }

    public void onClickShow(View v){


//        Toast.makeText(MainActivity.this, marker_list.get(0), Toast.LENGTH_SHORT).show();

//        Bundle args = new Bundle();
//        args.putParcelable("loc", current_location);
//        args.putString("mark", current_name);
//        args.putStringArrayList("Array_marker", marker_list);
//        args.putParcelableArrayList("Array_location", loc_list);

        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//        intent.putExtras(args);
        startActivity(intent);

    }


}
