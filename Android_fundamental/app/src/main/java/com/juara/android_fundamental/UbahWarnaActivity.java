package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class UbahWarnaActivity extends AppCompatActivity {

    private TextView txtKalimat;
    private Button btnUbah;
    private String [] warna = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_warna);

        txtKalimat = findViewById(R.id.txtText);
        btnUbah = findViewById(R.id.btn_ubah_warna);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get random color
                Random random = new Random();
                String colorName = warna[random.nextInt(20)];

                int colorResourceName = getResources().getIdentifier(colorName,
                        "color", getApplicationContext().getPackageName());

//                int colorRes = getResources().getColor(colorResourceName, this.getTheme());
                int colorRes = ContextCompat.getColor(UbahWarnaActivity.this,
                        colorResourceName);
                txtKalimat.setTextColor(colorRes);
            }
        });

        if (savedInstanceState != null){
            txtKalimat.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", txtKalimat.getCurrentTextColor());
    }
}