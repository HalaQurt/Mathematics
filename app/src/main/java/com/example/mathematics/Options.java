package com.example.mathematics;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Options extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private  Button btnStudent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_optiones);

        showButtons();



        // Set padding based on system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OptionsActivity", "Button 1 clicked"); // Add this line
                try {
                    startActivity(new Intent(Options.this, Students.class));
                } catch (Exception e) {
                    Log.e("OptionsActivity", "Error starting Students activity", e); // Add this line
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OptionsActivity", "Button 2 clicked"); // Log button click
                try {
                    startActivity(new Intent(Options.this, Quizes.class));
                } catch (Exception e) {
                    Log.e("OptionsActivity", "Error starting Quizes Activity", e); // Log error if starting activity fails
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OptionsActivity", "Button 3 clicked"); // Log button click
                try {
                    startActivity(new Intent(Options.this, MultiplicationTableActivity.class));
                } catch (Exception e) {
                    Log.e("OptionsActivity", "Error starting MultiplicationTable Activity", e); // Log error if starting activity fails
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OptionsActivity", "Button 4 clicked"); // Add this line
                try {
                    startActivity(new Intent(Options.this, Calculator.class));
                } catch (Exception e) {
                    Log.e("OptionsActivity", "Error starting Calculator activity", e); // Add this line
                }
            }
        });


    }


    private void showButtons() {
        btn1 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btnStudent = findViewById(R.id.btnStudent);
    }

}
