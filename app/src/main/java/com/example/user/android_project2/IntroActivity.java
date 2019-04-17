package com.example.user.android_project2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class IntroActivity extends AppCompatActivity {

    Handler h = new Handler();
    Runnable r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        h.postDelayed(r = new Runnable() {
            @Override
            public void run() {

                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                    startActivity(intent);
                    finish();


            }
        },2000);
    }
}