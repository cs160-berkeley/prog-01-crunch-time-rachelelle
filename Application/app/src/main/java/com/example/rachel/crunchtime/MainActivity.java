package com.example.rachel.crunchtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
//        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
//                .createFromResource(this, R.array.brew_array,
//                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
//        staticAdapter
//                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
//        staticSpinner.setAdapter(staticAdapter);

        final Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        final String[] items = new String[]{"Pushup", "Situp", "Jumping Jacks", "Jogging", "Squats",
                "Leg-lift","Plank", "Pullup", "Cycling", "Walking", "Swimming", "Stair-Climbing"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));

                final TextView type = (TextView) findViewById(R.id.type);
                String typeText = dynamicSpinner.getSelectedItem().toString();
                if (typeText == "Pushup" || typeText == "Situp" || typeText == "Squats" || typeText == "Pullup"){
                    type.setText("Reps");
                } else {
                    type.setText("Min");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        final EditText enterValue = (EditText) findViewById(R.id.edit_message);
        final TextView calorieCount = (TextView) findViewById(R.id.calorie_count);
        final TextView pushupText = (TextView) findViewById(R.id.pushup_text);
        final TextView situpText = (TextView) findViewById(R.id.situp_text);
        final TextView jumpingjackText = (TextView) findViewById(R.id.jumpingjack_text);
        final TextView joggingText = (TextView) findViewById(R.id.jogging_text);

        Button buttonConvert = (Button) findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = Double.valueOf(enterValue.getText().toString());
                double calories;
                double pushup;
                double situp;
                double jumpingjack;
                double jogging;

                String exerciseType = dynamicSpinner.getSelectedItem().toString();

                if (exerciseType == "Pushup"){
                    pushup = value;
                    situp = value * 0.57;
                    jumpingjack = value * 0.028;
                    jogging = value * 0.034;
                    calories = value * 0.2857;
                } else if (exerciseType == "Situp"){
                    situp = value;
                    pushup = value * 1.75;
                    jumpingjack = value * 0.05;
                    jogging = value * 0.06;
                    calories = value * 0.5;
                } else if (exerciseType == "Jumping Jacks"){
                    pushup = value * 35;
                    situp = value * 20;
                    jumpingjack = value;
                    jogging = value * 1.2;
                    calories = value * 10;
                } else if (exerciseType == "Jogging"){
                    pushup = value * 29.16;
                    situp = value * 16.66;
                    jumpingjack = value * 0.83;
                    jogging = value;
                    calories = value * 8.33;
                } else if (exerciseType == "Squats"){
                    pushup = value * 1.55;
                    situp = value * 0.88;
                    jumpingjack = value * 0.044;
                    jogging = value * 0.0533;
                    calories = value * 0.44;
                } else if (exerciseType == "Leg-lift"){
                    pushup = value * 14;
                    situp = value * 8;
                    jumpingjack = value * 2.5;
                    jogging = value * 0.48;
                    calories = value * 4;
                } else if (exerciseType == "Plank"){
                    pushup = value * 14;
                    situp = value * 8;
                    jumpingjack = value * 2.5;
                    jogging = value * 0.48;
                    calories = value * 4;
                } else if (exerciseType == "Pullup"){
                    pushup = value * 3.5;
                    situp = value * 2;
                    jumpingjack = value * 0.1;
                    jogging = value * 0.12;
                    calories = value * 10;
                } else if (exerciseType == "Cycling"){
                    pushup = value * 29.167;
                    situp = value * 16.66;
                    jumpingjack = value * 0.83;
                    jogging = value;
                    calories = value * 8.33;
                } else if (exerciseType == "Walking"){
                    pushup = value * 17.5;
                    situp = value * 10;
                    jumpingjack = value * 0.5;
                    jogging = value * 0.6;
                    calories = value * 5;
                } else if (exerciseType == "Swimming"){
                    pushup = value * 26.92;
                    situp = value * 15.38;
                    jumpingjack = value * 0.769;
                    jogging = value * 0.92;
                    calories = value * 7.69;
                } else if (exerciseType == "Stair-Climbing"){
                    pushup = value * 23.33;
                    situp = value * 13.33;
                    jumpingjack = value * 0.667;
                    jogging = value * 0.8;
                    calories = value * 7.467;
                } else {
                    pushup = 0;
                    situp = 0;
                    jumpingjack = 0;
                    jogging = 0;
                    calories = 0;
                }

                calorieCount.setText("You lost "+String.valueOf(Math.floor(calories * 100) / 100)+" calories!");
                pushupText.setText("Pushups: "+String.valueOf(Math.floor(pushup * 100) / 100)+" reps");
                situpText.setText("Situps: "+String.valueOf(Math.floor(situp * 100) / 100)+" reps");
                jumpingjackText.setText("Jumping Jacks: "+String.valueOf(Math.floor(jumpingjack * 100) / 100)+" min");
                joggingText.setText("Jogging: "+String.valueOf(Math.floor(jogging * 100) / 100)+" min");
            }
        });

    }
}
