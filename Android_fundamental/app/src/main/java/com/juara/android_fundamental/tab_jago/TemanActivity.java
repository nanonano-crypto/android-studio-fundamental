package com.juara.android_fundamental.tab_jago;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.juara.android_fundamental.R;

public class TemanActivity extends ListActivity {

    String [] teman ={"Andra", "Dina", "Edo", "Julia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teman);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teman));
    }
}