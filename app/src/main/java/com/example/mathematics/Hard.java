package com.example.mathematics;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Hard extends AppCompatActivity {
    TextView txtHard;
    TextView txtHardQ1;
    TextView txtHardQ2;
    RadioGroup FirstGroupH;
    RadioGroup SecondGroupH;
    RadioButton btnHard1;
    RadioButton btnHard2;
    RadioButton btnHard3;
    RadioButton btnHard4;
    RadioButton btnHard5;
    RadioButton btnHard6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        EdgeToEdge.enable(this);
        showViews();

        // Set up click listeners for the first group of radio buttons
        btnHard1.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnHard1.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnHard2.setTextColor(Color.BLACK);
            btnHard3.setTextColor(Color.BLACK);
        });

        btnHard2.setOnClickListener(v -> {
            // Change color to green for the clicked button
            btnHard2.setTextColor(Color.GREEN);
            // Change color to red for other buttons in the group
            btnHard1.setTextColor(Color.BLACK);
            btnHard3.setTextColor(Color.BLACK);
        });

        btnHard3.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnHard3.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnHard1.setTextColor(Color.BLACK);
            btnHard2.setTextColor(Color.BLACK);
        });

        // Set up click listeners for the second group of radio buttons
        btnHard4.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnHard4.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnHard5.setTextColor(Color.BLACK);
            btnHard6.setTextColor(Color.BLACK);
        });

        btnHard5.setOnClickListener(v -> {
            // Change color to red for the clicked button
            btnHard5.setTextColor(Color.RED);
            // Change color to red for other buttons in the group
            btnHard4.setTextColor(Color.BLACK);
            btnHard6.setTextColor(Color.BLACK);
        });

        btnHard6.setOnClickListener(v -> {
            // Change color to green for the clicked button
            btnHard6.setTextColor(Color.GREEN);
            // Change color to red for other buttons in the group
            btnHard4.setTextColor(Color.BLACK);
            btnHard5.setTextColor(Color.BLACK);
        });

        // Add other necessary setup code here...
    }




    public void showViews() {
        txtHard = findViewById(R.id.txtHard);
        txtHardQ1 = findViewById(R.id.txtHardQ1);
        txtHardQ2 = findViewById(R.id.txtHardQ2);
        FirstGroupH = findViewById(R.id.FirstGroupH);
        SecondGroupH = findViewById(R.id.SecondGroupH);
        btnHard1 = findViewById(R.id.btnHard1);
        btnHard2 = findViewById(R.id.btnHard2);
        btnHard3 = findViewById(R.id.btnHard3);
        btnHard4 = findViewById(R.id.btnHard4);
        btnHard5 = findViewById(R.id.btnHard5);
        btnHard6 = findViewById(R.id.btnHard6);
    }

    // Method to change radio button color based on clicked button

}
