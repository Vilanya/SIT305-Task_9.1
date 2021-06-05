package com.example.restaurantmapapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        ArrayList<LatLng> location = ((MyApplication) getApplication()).getLocations();
        ArrayList<String> marker = ((MyApplication) getApplication()).getNames();
        Toast.makeText(MapsActivity.this, marker.get(0), Toast.LENGTH_SHORT).show();

//        ArrayList<LatLng> location  = getIntent().getParcelableArrayListExtra("Array_location");
//        ArrayList<String> marker = getIntent().getStringArrayListExtra("Array_marker");
//        String name = getIntent().getStringExtra("mark");
//        LatLng location = getIntent().getParcelableExtra("loc");


//        Iterator<String> it1 = marker.iterator();
//        Iterator<LatLng> it2 = location.iterator();
//
//        while (it1.hasNext() && it2.hasNext()) {
//            mMap.addMarker(new MarkerOptions().position(it2).title(it1));
//        }

        for (int i = 0; i < location.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(location.get(i)).title(marker.get(i)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location.get(0)));

//
//        mMap.addMarker(new MarkerOptions().position(location).title(name));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
