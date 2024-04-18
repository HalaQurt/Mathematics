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

public class Quizes extends AppCompatActivity {

    Button btneasy ;
    Button btnhard ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quizes);
        showButtons();

        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("EasyActivity", "Button 1 clicked"); // Log button click
                try {
                    startActivity(new Intent(Quizes.this, Easy.class));
                } catch (Exception e) {
                    Log.e("QuizesActivity", "Error starting Easy Activity", e); // Log error if starting activity fails
                }
            }
        });
        btnhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("QuizesActivity", "Button Hard clicked"); // Log button click
                try {
                    startActivity(new Intent(Quizes.this, Hard.class));
                } catch (Exception e) {
                    Log.e("QuizesActivity", "Error starting Hard Activity", e); // Log error if starting activity fails
                }
            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            }

            private void showButtons() {
                btneasy = findViewById(R.id.btneasy);
                btnhard = findViewById(R.id.btnhard);
            }
        }