package com.example.mathematics;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTableActivity extends AppCompatActivity {

    private Spinner numberSpinner;
    private ListView multiplicationListView;
    private TextView txtnum;
    private TextView txtHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table);

        numberSpinner = findViewById(R.id.numberSpinner);
        multiplicationListView = findViewById(R.id.multiplicationListView);
        txtnum = findViewById(R.id.txtnum);
        txtHidden = findViewById(R.id.txtHidden);
        Button searchButton = findViewById(R.id.searchButton);

        // Set txtHidden initially to GONE
        txtHidden.setVisibility(View.GONE);

        // Populate the spinner with numbers from 1 to 10
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(String.valueOf(i));
        }
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numbers);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberSpinner.setAdapter(spinnerAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiplicationTable();
            }
        });

        multiplicationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Calculate the result based on the selected number and the position in the list
                int number = Integer.parseInt(numberSpinner.getSelectedItem().toString());
                int times = position + 1;
                // Set the text in txtHidden
                txtHidden.setText(generateRepeatedAddition(number, times));
                // Make txtHidden visible
                txtHidden.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showMultiplicationTable() {
        int number = Integer.parseInt(numberSpinner.getSelectedItem().toString());
        List<String> tableEntries = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tableEntries.add(number + " x " + i + " = " + (number * i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableEntries);
        multiplicationListView.setAdapter(adapter);
    }

    // Helper method to generate repeated addition expression
    private String generateRepeatedAddition(int number, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(number);
            if (i < times - 1) {
                builder.append(" + ");
            }
        }
        return builder.toString();
    }
}
