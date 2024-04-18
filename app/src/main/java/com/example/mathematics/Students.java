package com.example.mathematics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Students extends AppCompatActivity {
    TextView txtreg;
    EditText TxtName;
    EditText TxtAge;
    Button btnSave;
    Button btnLoad;
    TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        txtreg = findViewById(R.id.txtreg);
        TxtName = findViewById(R.id.TxtName);
        TxtAge = findViewById(R.id.TxtAge);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtresult = findViewById(R.id.txtresult);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeEmptyEntries();
                loadDataAndDisplay();
            }
        });

    }

    private void saveData() {
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String nameInput = TxtName.getText().toString().trim();
        String ageInput = TxtAge.getText().toString().trim();

        if (nameInput.isEmpty()) {
            TxtName.setError("Name cannot be empty");
            return;
        }

        int ageValue;
        try {
            ageValue = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            TxtAge.setError("Invalid age format");
            return;
        }

        String newData = "Student Name: " + nameInput + ", Age: " + ageInput + "\n";

        // Append the new data to the existing data in SharedPreferences
        String existingData = sharedPref.getString("TextViewText", "");
        String combinedData = existingData + newData;
        editor.putString("TextViewText", combinedData);
        editor.apply();

        // Display the combined data in the txtresult TextView
        txtresult.setText(combinedData);
    }


    private void loadDataAndDisplay() {
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        StringBuilder displayTextBuilder = new StringBuilder(); // Initialize StringBuilder to hold all data

        // Retrieve the saved data
        String savedData = sharedPref.getString("TextViewText", "");

        // Append the saved data to the display text
        displayTextBuilder.append(savedData);

        // Set the concatenated text to the txtresult TextView
        txtresult.setText(displayTextBuilder.toString());
    }





    private void removeEmptyEntries() {
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String textViewText = sharedPref.getString("TextViewText", "");

        // Check if textViewText is empty
        if (TextUtils.isEmpty(textViewText)) {
            return; // If empty, no need to remove entries
        }

        // Split the text by newline character to get individual lines
        String[] lines = textViewText.split("\n");

        StringBuilder newTextBuilder = new StringBuilder();
        for (String line : lines) {
            // Split each line by comma to separate name and age
            String[] parts = line.split(", ");
            if (parts.length == 2) {
                String name = parts[0].substring(parts[0].indexOf(":") + 2);
                String age = parts[1].substring(parts[1].indexOf(":") + 2);
                // Check if name and age are not empty
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age)) {
                    // Append the line to newTextBuilder
                    newTextBuilder.append(line).append("\n");
                }
            }
        }

        // Update the "TextViewText" entry with the new text
        editor.putString("TextViewText", newTextBuilder.toString());
        editor.apply();
    }

}
