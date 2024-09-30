package com.example.proy03_c2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EnviarActivity2 extends AppCompatActivity {
    private EditText valor1;
    private EditText valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enviar2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        valor1 = findViewById(R.id.txtResult1);
        valor2 = findViewById(R.id.txtResult2);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String v1 = bundle.getString("Valor1", "No se encontró el valor");
            String v2 = bundle.getString("Valor2", "No se encontró el valor");

            Toast.makeText(this, "Valor 1: " + v1 + "\nValor 2: " + v2, Toast.LENGTH_LONG).show();
            valor1.setText(v1);
            valor2.setText(v2);
        }
    }

    public void cerrar(View v) {
        this.finish();
    }

}