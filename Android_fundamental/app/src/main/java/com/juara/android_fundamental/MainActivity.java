package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPindah(View view) {
        Intent intent = new Intent(MainActivity.this, HelloWorldActivity.class);
        startActivity(intent);
    }

    public void btnUi(View view) {
        Intent intent = new Intent(MainActivity.this, UiInteractiveActivity.class);
        startActivity(intent);
    }

    public void btnRelative(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
        startActivity(intent);
    }

    public void btnScroll(View view) {
        Intent intent = new Intent(MainActivity.this, ScrollviewActivity.class);
        startActivity(intent);
    }

    public void btnParsing(View view) {
            Intent intent = new Intent(MainActivity.this, ParsingDataActivity.class);
            startActivity(intent);
    }

    public void btnImplisit(View view) {
        Intent intent = new Intent(MainActivity.this, ImplisitActivity.class);
        startActivity(intent);
    }

    public void btnDebugger(View view) {
        Intent intent = new Intent(MainActivity.this, DebuggerActivity.class);
        startActivity(intent);
    }

    public void btnUbahWarna(View view) {
        Intent intent = new Intent(MainActivity.this, UbahWarnaActivity.class);
        startActivity(intent);
    }

    public void btnImageClick(View view) {
        Intent intent = new Intent(MainActivity.this, ImageClickActivity.class);
        startActivity(intent);
    }
}