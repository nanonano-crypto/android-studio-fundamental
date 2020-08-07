package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageClickActivity extends AppCompatActivity {

    private ImageView satu, dua, tiga, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_click);

        satu = findViewById(R.id.imgSatu);
        dua = findViewById(R.id.imgDua);
        tiga = findViewById(R.id.img_tiga);
        next = findViewById(R.id.img_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageClickActivity.this, OrderDroidCafeActivity.class);
                startActivity(intent);
            }
        });
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
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }
}