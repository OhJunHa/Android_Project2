package com.example.user.android_project2;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        ArrayList<MarkerItem> alTMapPoint = new ArrayList();
        alTMapPoint.add(new MarkerItem(37.403550, 126.930403));
        alTMapPoint.add(new MarkerItem(37.403260, 126.930618));

        LatLng SEOUL = new LatLng(37.403260, 126.930618);

        for(int i=0; i<alTMapPoint.size(); i++) {



            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(alTMapPoint.get(i).getLat(), alTMapPoint.get(i).getLon()));
            markerOptions.title("서울");
            markerOptions.snippet("한국의 수도");
            map.addMarker(markerOptions);

        }

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

}