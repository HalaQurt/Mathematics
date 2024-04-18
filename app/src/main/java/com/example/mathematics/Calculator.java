package com.example.mathematics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;




    public class Calculator extends AppCompatActivity {

        private EditText number1EditText;
        private EditText number2EditText;
        private Spinner operationSpinner;
        private TextView resultTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator);

            // Initialize views
            number1EditText = findViewById(R.id.number1EditText);
            number2EditText = findViewById(R.id.number2EditText);
            operationSpinner = findViewById(R.id.operationSpinner);
            resultTextView = findViewById(R.id.resultTextView);

            // Populate the Spinner with operation choices
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.operations_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            operationSpinner.setAdapter(adapter);

            // Initialize and set OnClickListener for the calculate button
            Button calculateButton = findViewById(R.id.calculateButton);
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate();
                }
            });
        }

        private void calculate() {
            // Get the numbers entered by the user
            String number1Str = number1EditText.getText().toString();
            String number2Str = number2EditText.getText().toString();

            // Check if both EditText fields are not empty
            if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
                // Parse the numbers from String to double
                double number1 = Double.parseDouble(number1Str);
                double number2 = Double.parseDouble(number2Str);

                // Perform the selected operation
                String operation = operationSpinner.getSelectedItem().toString();
                double result = 0;
                switch (operation) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            resultTextView.setText("Error: Division by zero");
                            return;
                        }
                        break;
                }

                // Display the result
                resultTextView.setText("Result: " + result);
            } else {
                // If any EditText field is empty, show a message
                resultTextView.setText("Please enter both numbers");
            }
        }
    }

