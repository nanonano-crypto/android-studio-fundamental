package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ParsingDataActivity extends AppCompatActivity {

    private static final String LOG_TAG = ParsingDataActivity.class.getSimpleName() ;
    private EditText etKalimat;
    public static final String EXTRA_MESSAGE =
            "com.juara.android_fundamental.ParsingDataActivity.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_data);

        etKalimat = findViewById(R.id.etKalimat);
    }

    public void btnSend(View view) {
        Log.d(LOG_TAG, "Button clicked");
        Intent intent = new Intent(this, RelativeActivity.class);
        String message = etKalimat.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}