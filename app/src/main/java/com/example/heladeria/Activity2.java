package com.example.heladeria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    private TextView vainilla, fresa, chocolate, tipo;
    private Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        vainilla = findViewById(R.id.result_vainilla);
        fresa = findViewById(R.id.result_fresa);
        chocolate = findViewById(R.id.result_chocolate);
        tipo = findViewById(R.id.result_tipo);

        /*
        Intent intent = getIntent();

        String resultV = intent.getStringExtra("dataVainilla");
        vainilla.setText(resultV);
        vainilla.setTextColor(Color.parseColor("#FFFF00"));

        String resultF = intent.getStringExtra("dataFresa");
        fresa.setText(resultF);
        fresa.setTextColor(Color.parseColor("#A64D79"));

        String resultC = intent.getStringExtra("dataChocolate");
        chocolate.setText(resultC);
        chocolate.setTextColor(Color.parseColor("#876A0F"));

        String resultSpinner = intent.getStringExtra("spinnerData");
        String resultColor = intent.getStringExtra("spinnerColor");
        tipo.setText(resultSpinner);
        tipo.setTextColor(Color.parseColor(resultColor));
        */
        end = findViewById(R.id.end);
        end.setOnClickListener(view -> Activity2.this.finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}