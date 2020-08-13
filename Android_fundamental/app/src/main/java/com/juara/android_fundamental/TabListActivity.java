package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TabListActivity extends AppCompatActivity {

    private Button satu, dua, tiga, empat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list);

        satu = findViewById(R.id.btn_satu);
        dua = findViewById(R.id.btn_dua);
        tiga = findViewById(R.id.btn_jago);
        empat = findViewById(R.id.btn_wildhan);

        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabListActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });

        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabListActivity.this, TabJagoCodingActivity.class);
                startActivity(intent);
            }
        });
        empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabListActivity.this, TabWildhanTechnoActivity.class);
                startActivity(intent);
            }
        });
    }
}