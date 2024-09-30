package com.example.proy03_c2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EnviarActivity3 extends AppCompatActivity {
    private EditText num1;
    private EditText operaciones;
    private EditText num2;
    private EditText resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enviar3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        num1 = findViewById(R.id.txtNumero1);
        operaciones = findViewById(R.id.txtOperacion);
        num2 = findViewById(R.id.txtNumero2);
        resultado = findViewById(R.id.txtResultado);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String v1 = bundle.getString("Valor1", "No se encontró el valor");
            String v2 = bundle.getString("Valor2", "No se encontró el valor");
            String v3 = bundle.getString("Valor3", "No se encontró el valor");


            num1.setText(v1);
            num2.setText(v2);
            operaciones.setText(v3);

            int nro1 = Integer.parseInt(v1);
            int nro2 = Integer.parseInt(v2);

            int operacioFin = calcular(nro1, nro2, v3);
            String resultadoString = String.valueOf(operacioFin);
            this.resultado.setText(resultadoString);

            switch (v3) {
                case "Suma":
                    Toast.makeText(this, v1 + " + " + v2 + " = " + resultadoString, Toast.LENGTH_LONG).show();
                    break;
                case "Resta":
                    Toast.makeText(this, v1 + " - " + v2 + " = " + resultadoString, Toast.LENGTH_LONG).show();
                    break;
                case "Multiplicación":
                    Toast.makeText(this, v1 + " x " + v2 + " = " + resultadoString, Toast.LENGTH_LONG).show();
                    break;
                case "División":
                    Toast.makeText(this, v1 + " / " + v2 + " = " + resultadoString, Toast.LENGTH_LONG).show();
                    break;
            }
        }

    }

    public int calcular(int nro1, int nro2, String operacion) {
        int resultado = 0;
        switch (operacion) {
            case "Suma":
                resultado = nro1 + nro2;
                break;
            case "Resta":
                resultado = nro1 - nro2;
                break;
            case "Multiplicación":
                resultado = nro1 * nro2;
                break;
            case "División":
                resultado = nro1 / nro2;
                break;
        }
        return resultado;
    }

    public void cerrar(View v) {
        this.finish();
    }
}