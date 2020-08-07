package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ImplisitActivity extends AppCompatActivity {

    private EditText uri, alamat, kalimat;
    private Button btnWeb, btnMap, btnShare;
    private static final int pic_id = 1;
    private ImageView camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implisit);

        uri = findViewById(R.id.et_uri);
        alamat = findViewById(R.id.et_alamat);
        kalimat = findViewById(R.id.et_kalimat);
        btnWeb = findViewById(R.id.btnOpen);
        btnMap = findViewById(R.id.btnMap);
        btnShare = findViewById(R.id.btnShare);
        camera = findViewById(R.id.imgCamera);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the URL text.
                String url = uri.getText().toString();

                // Parse the URI and create the intent.
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                // Find an activity to hand the intent and start that activity.
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = alamat.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Log.d("ImplisitActivity", "canot handle");
                }
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = kalimat.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(ImplisitActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("apa")
                        .setText(txt)
                        .startChooser();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });

    }
}