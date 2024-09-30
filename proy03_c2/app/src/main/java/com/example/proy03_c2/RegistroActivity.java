package com.example.proy03_c2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtResp = findViewById(R.id.txtResult);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String v1 = bundle.getString("Valor1", "No se encontro el valor");
            String v2 = bundle.getString("Valor2", "No se encontro el valor");

            int calc = Integer.parseInt(v1) + Integer.parseInt(v2);
            Log.i("Valores", v1);
            Log.i("Valores", v2);
            Log.i("Valores", String.valueOf(calc));
            txtResp.setText("La suma de " + v1 + " y " + v2 + "\nes: " + calc);
        }
    }

    public void cerrar(View v) {
        this.finish();
    }

}