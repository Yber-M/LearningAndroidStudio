package com.example.proy03_c2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nro1, nro2;
    private Spinner operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nro1 = findViewById(R.id.txtNro1);
        nro2 = findViewById(R.id.txtNro2);
        operaciones = findViewById(R.id.spnOperaciones);
    }

    public void procesar(View v) {
        Intent intent = new Intent(this, RegistroActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("Valor1", nro1.getText().toString());


        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void enviar2(View v) {
        Intent intent = new Intent(this, EnviarActivity2.class);

        Bundle bundle = new Bundle();
        bundle.putString("Valor1", nro1.getText().toString());
        bundle.putString("Valor2", nro2.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void enviar3(View v) {
        Intent intent = new Intent(this, EnviarActivity3.class);

        Bundle bundle = new Bundle();
        bundle.putString("Valor1", nro1.getText().toString());
        bundle.putString("Valor2", nro2.getText().toString());
        bundle.putString("Valor3", operaciones.getSelectedItem().toString());

        intent.putExtras(bundle);

        startActivity(intent);

    }

}