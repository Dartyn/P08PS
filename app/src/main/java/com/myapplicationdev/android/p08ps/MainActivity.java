package com.myapplicationdev.android.p08ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView tv;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {

                map = googleMap;

                LatLng poi_North = new LatLng(1.419, 103.8251);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North,
                        15));
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_North)
                        .title("Causeway Point")
                        .snippet("Shopping after class")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }
            }

        });
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        tv = (TextView) findViewById(R.id.text);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng poi_East = new LatLng(1.2494, 103.8303);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East,
                        15));
                Marker rp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_East)
                        .title("Sentosa")
                        .snippet("Sentosa")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            tv.setText("Sentosa");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng poi_West = new LatLng(1.3304, 103.7243);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_West,
                        15));
                Marker rp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_West)
                        .title("Jurong Secondary School")
                        .snippet("C347 Android Programming IIwgwgsg")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
                tv.setText("Jurong Secondary School");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
                LatLng poi_Central = new LatLng(1.3020, 103.8971);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central,
                        15));
                Marker rp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Central)
                        .title("Marina Parade")
                        .snippet("Singapore Flyer")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
                tv.setText("Marina Parade");
            }
        });

    }
}
