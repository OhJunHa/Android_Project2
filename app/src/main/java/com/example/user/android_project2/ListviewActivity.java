package com.example.user.android_project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv1 = (ListView) findViewById(R.id.ddd);

        List<String> list = new ArrayList<>();

        list.add("대림대 전산관 5층 테라스");
        list.add("대림대 율곡관 앞 흡연부스");
        list.add("대림대 자동차관 앞 흡연구역");
        list.add("대림대 임곡관 뒤 흡연구역");
        list.add("대림대 수암관 앞 흡연구역");
        list.add("대림대 한림관 옆 흡연구역");
        list.add("대림대 생활관 뒤 흡연구역");
        list.add("안양지구대 옆 흡연구역");
        list.add("안양로 332번길 CU 뒤 흡연구역");
        list.add("롯데백화점 평촌점 10층 흡연구역");
        list.add("중앙공원 흡연구역");
        list.add("평촌도서관 흡연구역");
        list.add("평촌역 2번출구 흡연구역");
        list.add("안양일번가 철구PC 흡연구역");
        list.add("안양일번가 할리스커피 흡연구역");
        list.add("안양일번가 썸당구장 흡연구역");
        list.add("안양일번가 조이당구장 흡연구역");
        list.add("안양일번가 캠프PC 흡연구역");
        list.add("안양일번가 홍진호PC 흡연구역");



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list) ;


        lv1.setAdapter(adapter);

    }
}
