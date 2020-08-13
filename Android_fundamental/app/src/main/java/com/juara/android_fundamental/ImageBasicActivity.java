package com.juara.android_fundamental;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageBasicActivity extends AppCompatActivity {

    private ImageView satu, dua, tiga;
    public static final String EXTRA_MESSAGE =
            "com.juara.android_fundamental.extra.MESSAGE";
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        satu = findViewById(R.id.imgSatu);
        dua = findViewById(R.id.imgDua);
        tiga = findViewById(R.id.img_tiga);

        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("anda memilih  donut satu");
            }
        });
        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("anda memilih  donut dua");
            }
        });
        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("anda memilih  donut tiga");
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageBasicActivity.this,
                        OrderDroidCafeActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }
}