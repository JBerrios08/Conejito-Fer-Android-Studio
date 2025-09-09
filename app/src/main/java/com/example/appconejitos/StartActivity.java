package com.example.appconejitos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button jugar = findViewById(R.id.btnJugar);
        Button reglas = findViewById(R.id.btnReglas);
        Button resultados = findViewById(R.id.btnResultados);

        jugar.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        reglas.setOnClickListener(v -> startActivity(new Intent(this, RulesActivity.class)));
        resultados.setOnClickListener(v -> startActivity(new Intent(this, ResultActivity.class)));
    }
}
