package com.group.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int first_value = 0, second_value = 0, tempResult = 0;
    String tempString = "";
    TextView textView, fullCalc;
    Button one, two, three, four, five, six, seven, eight, nine, zero
            , plus, multiply, divide, minus, equals, clear, mr, ms,mc;
    boolean add, subst, Multiplication, Division;

    ArrayList<Integer> savedValueMemory = new ArrayList<>();
    String[] valueArray;
    public void mathAction(String action){
        if(textView.getText().length() != 0){
            first_value = Integer.parseInt(textView.getText()+"");
            tempString += textView.getText()+"";
            textView.setText(null);
        }
        if(action.equals("add")){
            fullCalc.setText(fullCalc.getText()+" + ");
            tempString += " + ";
                    add = true;
        }else if(action.equals("minus")){
            fullCalc.setText(fullCalc.getText()+" - ");
            tempString += " - ";
            subst = true;
        }else if(action.equals("divide")){
            fullCalc.setText(fullCalc.getText()+" ÷ ");
            tempString += " ÷ ";
            Division = true;
        }else if(action.equals("multiply")){
            fullCalc.setText(fullCalc.getText()+" × ");
            tempString += " × ";
            Multiplication = true;
        }
    }
    public void parseArrayListToStringArr(){
        valueArray = new String[savedValueMemory.size()];
        for (int i=0; i < valueArray.length; i++)
        {
            valueArray[i] = ""+savedValueMemory.get(i).intValue();
        }
    }

    public void saveInMemory(int value){
        savedValueMemory.add(value);
    }
    public void readMemory(){
        parseArrayListToStringArr();
        AlertDialog dialogBox = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Pick value:")
                .setItems(valueArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, valueArray[which] + " checked", Toast.LENGTH_SHORT).show();
                        first_value = savedValueMemory.get(which);
                        tempString = "";
                        fullCalc.setText(first_value+"");
                        textView.setText(first_value+"");
                    }
                })
                .show();
    }

    public void clearMemory(){
        savedValueMemory.clear();
        valueArray = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        plus = (Button) findViewById(R.id.plus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        minus = (Button) findViewById(R.id.minus);
        equals = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);

        mr = (Button) findViewById(R.id.mr);
        ms = (Button) findViewById(R.id.ms);
        mc = (Button) findViewById(R.id.mc);


        textView = findViewById(R.id.calc_input);
        fullCalc = findViewById(R.id.fullCalc);

        /*
        Save value to memory
        Read value from memory
        */
        ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tempResult != 0) {
                    saveInMemory(tempResult);
                    Toast.makeText(MainActivity.this, "Saved in memory", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, " Nothing to save", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedValueMemory.isEmpty()) {
                    Toast.makeText(MainActivity.this, " Nothing in memory", Toast.LENGTH_SHORT).show();
                }else{
                    readMemory();
                }
            }
        });

        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearMemory();
                Toast.makeText(MainActivity.this, "Memory cleared", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        NUMBERS
        */

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "1");
                fullCalc.setText(tempString + textView.getText());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "2");
                fullCalc.setText(tempString + textView.getText());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "3");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "4");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "5");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "6");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "7");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "8");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "9");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "0");
                fullCalc.setText(tempString + textView.getText());

            }
        });

        /*
        Mathematical actions
        */

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathAction("add");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathAction("minus");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathAction("divide");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathAction("multiply");
            }
        });

        /*
        CLEAR
        */

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempString = "";
                textView.setText("");
                fullCalc.setText("");
                first_value = 0;
                second_value = 0;
                tempResult = 0;
            }
        });

        /*
        GET RESULT/ EQUALS
        */
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().length() != 0){
                    second_value = Integer.parseInt(textView.getText()+"");
                }
                if (add) {
                    tempResult = first_value + second_value;
                    textView.setText(tempResult + "");
                    add = false;
                }
                if (subst) {
                    tempResult = first_value - second_value;
                    textView.setText(tempResult + "");
                    subst = false;
                }
                if (Multiplication) {
                    tempResult = first_value * second_value;
                    textView.setText(tempResult + "");
                    Multiplication = false;
                }
                if (Division) {
                    tempResult = first_value / second_value;
                    textView.setText(tempResult + "");
                    Division = false;
                }
            }
        });

    }
}