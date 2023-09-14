package com.example.android_course_ata_2023.Section101.GoogleMaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityMyMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyMapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    ActivityMyMapsBinding binding;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        LatLng UCAS = new LatLng(31.497859350845747, 34.43666963823201);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(UCAS);
        markerOptions.title("UCAS");

        Marker m1 =  map.addMarker(markerOptions);
        m1.setTag("UCAS Marker");

        map.moveCamera(CameraUpdateFactory.newLatLng(UCAS));

        map.addMarker(new MarkerOptions().position(
                new LatLng(31.500144, 34.437600))
                .title("head of UCAS street")).setTag("head of UCAS street marker");

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                map.addMarker(new MarkerOptions().position(latLng).title("new position"));
            }
        });

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Toast.makeText(MyMapsActivity.this, ""+marker.getTag(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}