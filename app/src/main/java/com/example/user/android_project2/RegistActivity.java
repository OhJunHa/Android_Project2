package com.example.user.android_project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends AppCompatActivity {


    private EditText em01;
    private EditText pw01;
    private EditText pwco01;
    private Button jo01;
    private Button can01;


    View.OnClickListener btn1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("m_em",em01.getText().toString());
            ed.putString("m_pw",pw01.getText().toString());
            ed.commit();
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener btn2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        em01 = (EditText) findViewById(R.id.em01);
        pw01 = (EditText) findViewById(R.id.pw01);
        pwco01 = (EditText) findViewById(R.id.pwco01);
        jo01 = (Button) findViewById(R.id.jo01);
        can01 = (Button) findViewById(R.id.can01);

        jo01.setOnClickListener(btn1);
        can01.setOnClickListener(btn2);

        //비밀번호 검사
        pwco01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = pw01.getText().toString();
                String confirm = pwco01.getText().toString();

                if (password.equals(confirm) ) {
                    pw01.setBackgroundColor(Color.GREEN);
                    pwco01.setBackgroundColor(Color.GREEN);
                } else {
                    pw01.setBackgroundColor(Color.RED);
                    pwco01.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
