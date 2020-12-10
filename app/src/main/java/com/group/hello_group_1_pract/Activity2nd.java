package com.group.hello_group_1_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

public class Activity2nd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2nd);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("2-nd Activity");
    }
    @Override

    public void onDestroy() {
        super.onDestroy();
        finish();
    }


}