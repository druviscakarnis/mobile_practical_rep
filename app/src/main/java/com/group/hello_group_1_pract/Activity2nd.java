package com.group.hello_group_1_pract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2nd extends AppCompatActivity {
    private final String SHARED_PREFERENCES = "prefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2nd);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("2-nd Activity");

        Button read = findViewById(R.id.load);
        TextView textView = findViewById(R.id.prefs_text);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(SHARED_PREFERENCES,MODE_PRIVATE);

                String text = prefs.getString("Input", "");
                if(!text.equals("") && text!=null && !text.equals(" ")){
                    textView.setText(text);
                }else{
                    Toast.makeText(Activity2nd.this, "Nothing found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override

    public void onDestroy() {
        super.onDestroy();
        finish();
    }


}