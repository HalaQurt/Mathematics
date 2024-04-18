package com.example.mathematics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtname;
    TextView txtintro;
    Button butStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setUPViews();

        // Set OnClickListener for Start button
        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Options activity when button is clicked
               // Intent intent = new Intent(MainActivity.this, Options.class);
                startActivity(new Intent(MainActivity.this, Options.class ));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUPViews() {
        txtname = findViewById(R.id.txtname);
        txtintro = findViewById(R.id.txtintro);
        butStart = findViewById(R.id.butStart);
    }
}
