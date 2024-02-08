package com.college.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.college.converter.databinding.ActivityMainBinding;


import android.util.Log;


/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    static private final Float CONVERSION_RATE = 0.80F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("MainActivity", "onCreate started"); // Log message at the entry of onCreate

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.convertButton.setOnClickListener(view -> {
            convertCurrency(view);
        });

        Log.i("MainActivity", "onCreate completed"); // Log message at the exit of onCreate
    }

    public void convertCurrency(View view) {

        Log.i("MainActivity", "convertCurrency started"); // Log message at the entry of convertCurrency

        String inputAmount = binding.entryId.getText().toString();
        TextView resultView = binding.resultId;

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);

            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;

            resultView.setText( resultFloat + " Euros" );
        }
        Log.i("MainActivity", "convertCurrency completed"); // Log message at the exit of convertCurrency
    }
}