package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    private TextView kalimat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        kalimat = findViewById(R.id.txtHasil);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ParsingDataActivity.EXTRA_MESSAGE);
        kalimat.setText(message);
    }
}