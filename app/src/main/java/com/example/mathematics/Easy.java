package com.example.mathematics;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Easy extends AppCompatActivity {
    TextView txtEasy;
    TextView txtQ1;
    TextView txtQ2;
    RadioGroup FirstGroup;
    RadioGroup SecondGroup;
    RadioButton btnEasy1;
    RadioButton btnEasy2;
    RadioButton btnEasy3;
    RadioButton btnEasy4;
    RadioButton btnEasy5;
    RadioButton btnEasy6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        EdgeToEdge.enable(this);
        showViews();

        // Set up click listeners for the first group of radio buttons
        btnEasy1.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnEasy1.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnEasy2.setTextColor(Color.BLACK);
            btnEasy3.setTextColor(Color.BLACK);
        });

        btnEasy2.setOnClickListener(v -> {
            // Change color to green for the clicked button
            btnEasy2.setTextColor(Color.GREEN);
            // Change color to red for other buttons in the group
            btnEasy1.setTextColor(Color.BLACK);
            btnEasy3.setTextColor(Color.BLACK);
        });

        btnEasy3.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnEasy3.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnEasy1.setTextColor(Color.BLACK);
            btnEasy2.setTextColor(Color.BLACK);
        });

        // Set up click listeners for the second group of radio buttons
        btnEasy4.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnEasy4.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnEasy5.setTextColor(Color.BLACK);
            btnEasy6.setTextColor(Color.BLACK);
        });

        btnEasy5.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnEasy5.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnEasy4.setTextColor(Color.BLACK);
            btnEasy6.setTextColor(Color.BLACK);
        });

        btnEasy6.setOnClickListener(v -> {
            // Change color to green for the clicked button
            btnEasy6.setTextColor(Color.GREEN);
            // Change color to red for other buttons in the group
            btnEasy4.setTextColor(Color.BLACK);
            btnEasy5.setTextColor(Color.BLACK);
        });

        // Add other necessary setup code here...
    }




    public void showViews() {
        txtEasy = findViewById(R.id.txtEasy);
        txtQ1 = findViewById(R.id.txtQ1);
        txtQ2 = findViewById(R.id.txtQ2);
        FirstGroup = findViewById(R.id.FirstGroup);
        SecondGroup = findViewById(R.id.SecondGroup);
        btnEasy1 = findViewById(R.id.btnHard1);
        btnEasy2 = findViewById(R.id.btnHard2);
        btnEasy3 = findViewById(R.id.btnHard3);
        btnEasy4 = findViewById(R.id.btnHard4);
        btnEasy5 = findViewById(R.id.btnHard5);
        btnEasy6 = findViewById(R.id.btnHard6);
    }

    // Method to change radio button color based on clicked button

}
