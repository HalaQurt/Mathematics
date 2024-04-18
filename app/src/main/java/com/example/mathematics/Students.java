package com.example.mathematics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Students extends AppCompatActivity {
    TextView txtreg ;
    EditText TxtName ;
    EditText TxtAge ;
    Button btnSave ;
    Button btnLoad ;
    TextView txtresult ;

    private String name ;
    private  int age ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_students);
        ShowViews () ;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                String nameInput = TxtName.getText().toString().trim();
                String ageInput = TxtAge.getText().toString().trim();

                if (nameInput.isEmpty()) {
                    TxtName.setError("Name cannot be empty");
                    return;
                } else if (!nameInput.matches("[a-zA-Z]+")) {
                    TxtName.setError("Invalid name format");
                    return;
                }

                int ageValue;
                try {
                    ageValue = Integer.parseInt(ageInput);
                } catch (NumberFormatException e) {
                    TxtAge.setError("Invalid age format");
                    return;
                }

                editor.putString("Name", nameInput);
                editor.putInt("Age", ageValue); // Use "Age" as the key
                editor.apply();
            }
        });


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);

                // Retrieve saved values from SharedPreferences
                String savedName = sharedPref.getString("Name", "");
                int savedAge = sharedPref.getInt("Age", 0);

                // Retrieve the current text from txtresult
                String currentText = txtresult.getText().toString();

                // Append the retrieved values to the current text
                String newText = currentText + "Student Name: " + savedName + "\nAge: " + savedAge + "\n\n";

                // Display the combined result in TextView
                txtresult.setText(newText);
            }
        });







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ShowViews (){
        txtreg =findViewById(R.id.txtreg);
        TxtName = findViewById(R.id.TxtName);
        TxtAge =findViewById(R.id.TxtAge);
        btnSave =findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtresult =findViewById(R.id.txtresult);

    }


}