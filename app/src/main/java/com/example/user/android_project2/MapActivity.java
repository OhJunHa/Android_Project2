package com.example.user.android_project2;


import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;




@SuppressWarnings("ALL")

public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button button1 =(Button) findViewById(R.id.bt01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListviewActivity.class);
                startActivity(intent);

            }
        });


        Button button2 =(Button) findViewById(R.id.bt02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button button3 =(Button) findViewById(R.id.bt03);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HelpActivity.class);
                startActivity(intent);
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        ArrayList<MarkerItem> alTMapPoint = new ArrayList();
        alTMapPoint.add(new MarkerItem("대림대 전산관 5층 테라스",37.403550, 126.930403));
        alTMapPoint.add(new MarkerItem("대림대 율곡관 앞 흡연부스",37.403260, 126.930618));
        alTMapPoint.add(new MarkerItem("대림대 자동차관 앞 흡연구역",37.403429, 126.931561));
        alTMapPoint.add(new MarkerItem("대림대 임곡관 뒤 흡연구역",37.404041, 126.931210));
        alTMapPoint.add(new MarkerItem("대림대 수암관 앞 흡연구역",37.404577, 126.930393));
        alTMapPoint.add(new MarkerItem("대림대 한림관 옆 흡연구역",37.402459, 126.929155));
        alTMapPoint.add(new MarkerItem("대림대 생활관 뒤 흡연구역",37.404424, 126.931018));
        alTMapPoint.add(new MarkerItem("안양지구대 옆 흡연구역",37.401040, 126.922825));
        alTMapPoint.add(new MarkerItem("안양로 332번길 CU 뒤 흡연구역",37.401894, 126.919574));
        alTMapPoint.add(new MarkerItem("롯데백화점 평촌점 10층 흡연구역",37.390545, 126.950715));
        alTMapPoint.add(new MarkerItem("중앙공원 흡연구역",37.391740, 126.958936));
        alTMapPoint.add(new MarkerItem("평촌도서관 흡연구역",37.395826, 126.957902));
        alTMapPoint.add(new MarkerItem("평촌역 2번출구 흡연구역",37.394478, 126.963337));
        alTMapPoint.add(new MarkerItem("안양일번가 철구PC 흡연구역",37.399494, 126.923200));
        alTMapPoint.add(new MarkerItem("안양일번가 할리스커피 흡연구역",37.400025, 126.921054));
        alTMapPoint.add(new MarkerItem("안양일번가 썸당구장 흡연구역",37.399776, 126.922529));
        alTMapPoint.add(new MarkerItem("안양일번가 조이당구장 흡연구역",37.398813, 126.924265));
        alTMapPoint.add(new MarkerItem("안양일번가 캠프PC 흡연구역",37.398801, 126.923042));
        alTMapPoint.add(new MarkerItem("안양일번가 홍진호PC 흡연구역",37.398554, 126.922409));



        LatLng SEOUL = new LatLng(37.403260, 126.930618);

        for(int i=0; i<alTMapPoint.size(); i++) {



            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(alTMapPoint.get(i).getLat(), alTMapPoint.get(i).getLon()));
            markerOptions.title(alTMapPoint.get(i).getName());

            BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.maker_icon);
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 70, 70, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            map.addMarker(markerOptions);

        }

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));

    }

}