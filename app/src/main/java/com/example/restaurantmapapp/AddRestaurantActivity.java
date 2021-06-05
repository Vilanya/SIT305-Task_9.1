package com.example.restaurantmapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;


public class AddRestaurantActivity extends AppCompatActivity {
    LatLng current_location = new LatLng(0,0);
    String current_name = "empty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        Button button_get = (Button)findViewById(R.id.buttonGet);
        Button button_go_to_map = (Button)findViewById(R.id.buttonGoToMap);
        Button button_save = (Button)findViewById(R.id.buttonSave);
        TextView name = (TextView)findViewById(R.id.nameET);
        TextView location = (TextView)findViewById(R.id.locationET);

        current_name = getIntent().getStringExtra("NAME");
//        Toast.makeText(AddRestaurantActivity.this, current_name, Toast.LENGTH_SHORT).show();
        current_location = getIntent().getParcelableExtra("LOCATION");
//        double lat = current_location.latitude;
//        double lon = current_location.longitude;

        if (current_name != null){
            if(current_location != null){
                name.setText(current_name);
                double lat = current_location.latitude;
                double lon = current_location.longitude;
                location.setText(lat + " , " + lon);
            }

        }

    }

    public void onClickGet(View v){
        Intent intent = new Intent(AddRestaurantActivity.this, SearchPlaceActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickGo(View v){
        Bundle args = new Bundle();
        args.putParcelable("SHOW_LOCATION", current_location);
        args.putString("SHOW_MARKER", current_name);
        Intent intent = new Intent(AddRestaurantActivity.this, ShowMapActivity.class);
        intent.putExtras(args);
//        intent.putExtra("SHOW_MARKER", current_name);
        startActivity(intent);
    }

    public void onClickSave(View v){
        Bundle args = new Bundle();
        args.putParcelable("location", current_location);
        args.putString("marker", current_name);

        Intent intent = new Intent(AddRestaurantActivity.this, MainActivity.class);
        intent.putExtras(args);
        startActivity(intent);
    }
}
