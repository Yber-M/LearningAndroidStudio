package com.example.proy03_c2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

            Toast.makeText(this, "Valor: " + v1, Toast.LENGTH_LONG).show();
            txtResp.setText(v1);
        }
    }

    public void cerrar(View v) {
        this.finish();
    }

}