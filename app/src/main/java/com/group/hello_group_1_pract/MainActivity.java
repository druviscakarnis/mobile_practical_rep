package com.group.hello_group_1_pract;

<<<<<<< Updated upstream
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

=======
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

>>>>>>> Stashed changes
public class MainActivity extends AppCompatActivity {

    String selectedCheckBox;
    String temp;
<<<<<<< Updated upstream

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go2nd = findViewById(R.id.go_to_2nd);
        Button dialog = findViewById(R.id.go_dialog);

=======
    private Spinner spinner;
    private final String SHARED_PREFERENCES = "prefs";

    public String readPrefs(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFERENCES,MODE_PRIVATE);

        String returns = prefs.getString("Input", "");

        return returns;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button go2nd = findViewById(R.id.go_to_2nd);
        //Button dialog = findViewById(R.id.go_dialog);
        Button save = findViewById(R.id.load);
        EditText input = findViewById(R.id.input);
        String text = readPrefs();
        if(!text.equals("") && text!=null && !text.equals(" ")){
            input.setText(text);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* SAVE in preferences */
                SharedPreferences prefs = getSharedPreferences(SHARED_PREFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("Input", input.getText().toString());
                edit.apply();

                Log.v("Tests: ",input.getText().toString());
                String text = prefs.getString("Input", "");
                Log.v("Shared: ", text);
            }
        });
>>>>>>> Stashed changes
        go2nd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent go_to_2nd = new Intent(getApplicationContext(), Activity2nd.class);
                startActivity(go_to_2nd);
            }
<<<<<<< Updated upstream
        });


        dialog.setOnClickListener(new View.OnClickListener(){
=======


        });

        spinner = findViewById(R.id.theme_selector);

        String[] themes = getResources().getStringArray(R.array.theme_select);
        ArrayAdapter adapt = new ArrayAdapter(this,android.R.layout.simple_spinner_item, themes);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getId() == R.id.theme_selector){
                    String value = parent.getItemAtPosition(position).toString();
                    if(value.toLowerCase().equals("dark")){
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }else if(value.toLowerCase().equals("light")){
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }else if(value.toLowerCase().equals("default")){
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /* DIALOGS */
        /*dialog.setOnClickListener(new View.OnClickListener(){
>>>>>>> Stashed changes
            @Override
            public void onClick(View v) {
                String[] groupMembers = getResources().getStringArray(R.array.group_members_dialog);
                AlertDialog dialogBox = new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.group_nr_dialog)
                        .setMultiChoiceItems(R.array.group_members_dialog, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                if (isChecked) {
                                    Toast.makeText(MainActivity.this, groupMembers[which] + " checked", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, groupMembers[which] + " unchecked", Toast.LENGTH_SHORT).show();

                                }
                            }

                        })
                        .setPositiveButton("OK", null)
                        .setNegativeButton("Cancel", null)
                        .show();

                Button posButton = dialogBox.getButton(AlertDialog.BUTTON_POSITIVE);
                posButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });
                Button negButton = dialogBox.getButton(AlertDialog.BUTTON_NEGATIVE);
                negButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"You closed dialog", Toast.LENGTH_SHORT).show();
                        dialogBox.cancel();
                    }
                });

            }
        });
<<<<<<< Updated upstream


            /*public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle(R.string.group_nr_dialog);
                            builder.setCancelable(false);

                            String[] groupMembers = getResources().getStringArray(R.array.group_members_dialog);

                            builder.setMultiChoiceItems(R.array.group_members_dialog, null, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                    if(isChecked){
                                        Toast.makeText(MainActivity.this,groupMembers[which]+" checked", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(MainActivity.this,groupMembers[which]+" unchecked", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                            builder.setPositiveButton("OK", null);
                            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this,"You closed dialog", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                }
                            });
                            Button posButton = dialog.getButton
                            AlertDialog alertDialog = builder.create();

                            alertDialog.show();
                        }*/

=======
*/


>>>>>>> Stashed changes
    }
}

