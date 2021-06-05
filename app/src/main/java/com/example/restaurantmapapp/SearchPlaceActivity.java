package com.example.restaurantmapapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class SearchPlaceActivity extends AppCompatActivity {


    private static final String TAG = "Running ";
    public LatLng current_location;
    public String current_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_place);

        // Initialize the SDK
        Places.initialize(getApplicationContext(), "AIzaSyBPuQrmqdGPuF6I3ZjV-13tS8Qasy5fq5c");

        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
            getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.LAT_LNG, Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {

                current_location = place.getLatLng();
                current_name = place.getName();
//                Toast.makeText(SearchPlaceActivity.this, current_name.toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(SearchPlaceActivity.this, current_location.toString(), Toast.LENGTH_SHORT).show();
                double destlat = current_location.latitude;
                double destLon = current_location.longitude;
                Toast.makeText(SearchPlaceActivity.this, "" + destlat + ',' + destLon, Toast.LENGTH_LONG).show();
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(@NonNull Status status) {

                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }

    public void onClickOk(View v){
        Bundle args = new Bundle();
        args.putParcelable("LOCATION", current_location);
        args.putString("NAME",current_name);
        Intent intent = new Intent(SearchPlaceActivity.this, AddRestaurantActivity.class);
        intent.putExtras(args);
//        intent.putExtra("NAME",current_name);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
