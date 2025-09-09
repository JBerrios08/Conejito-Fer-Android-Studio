package com.example.appconejitos;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button inicio = findViewById(R.id.btnInicio);
        inicio.setOnClickListener(v -> finish());
    }
}
