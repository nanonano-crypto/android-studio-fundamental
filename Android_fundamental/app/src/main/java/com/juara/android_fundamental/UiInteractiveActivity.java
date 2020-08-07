package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UiInteractiveActivity extends AppCompatActivity {

    private  int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_interactive);

        mShowCount = findViewById(R.id.txtHasil);

    }

    public void btnCount(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void btnToast(View view) {
        Toast.makeText(UiInteractiveActivity.this, "Hello toast", Toast.LENGTH_LONG).show();
    }
}