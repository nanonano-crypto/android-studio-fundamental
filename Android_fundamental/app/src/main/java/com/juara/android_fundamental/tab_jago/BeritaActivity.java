package com.juara.android_fundamental.tab_jago;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.juara.android_fundamental.R;

public class BeritaActivity extends ListActivity {

    String [] berita ={"Jadwal Piala Dunia 2014", "Capres Indonesia", "Debat Capres", "Debat Cawapres"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berita);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, berita));
    }
}