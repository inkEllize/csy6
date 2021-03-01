package com.csy6.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        String name = getIntent().getStringExtra("key_name");
        String scores = "" + getIntent().getIntExtra("socres", 0);
        WinFragment winFragment = WinFragment.newInstance(name, scores);
        //android.R.id.content
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,winFragment).commit();
    }
}