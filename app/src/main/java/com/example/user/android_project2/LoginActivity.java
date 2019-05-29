package com.example.user.android_project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText em02;
    private EditText pw02;
    private Button bt04;

    View.OnClickListener btn1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            String id = sp.getString("m_em","");
            String pw = sp.getString("m_pw","");
            if (id.equals(em02.getText().toString())&& pw.equals(pw02.getText().toString())) {
                Intent i = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(i);
                finish();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        em02 = (EditText) findViewById(R.id.em02);
        pw02 = (EditText) findViewById(R.id.pw02);
        bt04 = (Button) findViewById(R.id.bt04);

        bt04.setOnClickListener(btn1);

        Button button5 =(Button) findViewById(R.id.bt05);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistActivity.class);
                startActivityForResult(intent, 1000);
                finish();
            }
        });
    }
}
