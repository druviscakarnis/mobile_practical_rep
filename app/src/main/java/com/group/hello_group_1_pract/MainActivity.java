package com.group.hello_group_1_pract;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {

    String selectedCheckBox;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go2nd = findViewById(R.id.go_to_2nd);
        Button dialog = findViewById(R.id.go_dialog);

        go2nd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent go_to_2nd = new Intent(getApplicationContext(), Activity2nd.class);
                startActivity(go_to_2nd);
            }
        });


        dialog.setOnClickListener(new View.OnClickListener(){
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

    }
}

