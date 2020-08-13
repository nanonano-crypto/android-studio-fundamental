package com.juara.android_fundamental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.app.TabActivity;

import com.juara.android_fundamental.tab_jago.BerandaActivity;
import com.juara.android_fundamental.tab_jago.BeritaActivity;
import com.juara.android_fundamental.tab_jago.TemanActivity;

@SuppressWarnings("deprecation")
public class TabJagoCodingActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_jago_coding);

        TabHost tabhost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, BerandaActivity.class);//content pada tab yang akan kita buat
        spec = tabhost.newTabSpec("beranda").setIndicator("Beranda",null).setContent(intent);//mengeset nama tab dan mengisi content pada menu tab anda.
        tabhost.addTab(spec);//untuk membuat tabbaru disini bisa diatur sesuai keinginan anda

        intent = new Intent().setClass(this, BeritaActivity.class);
        spec = tabhost.newTabSpec("berita").setIndicator("Berita",null).setContent(intent);
        tabhost.addTab(spec);

        intent = new Intent().setClass(this, TemanActivity.class);
        spec = tabhost.newTabSpec("teman").setIndicator("Teman",null).setContent(intent);
        tabhost.addTab(spec);
    }
}