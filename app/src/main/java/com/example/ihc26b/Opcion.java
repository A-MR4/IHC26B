package com.example.ihc26b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Opcion extends AppCompatActivity implements View.OnClickListener {
    private EditText e, e2;
    private TextView t;
    private Button b, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);

        b = findViewById(R.id.button5);
        b2 = findViewById(R.id.button6);
        b3 = findViewById(R.id.button7);
        b4 = findViewById(R.id.button8);
        e = findViewById(R.id.editTextText2);
        e2 = findViewById(R.id.editTextText3);
        t = findViewById(R.id.textView4);

        b.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String n1 = e.getText().toString();
        String n2 = e2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            t.setText("Ingresa ambos números");
            return;
        }

        try {
            double numero1 = Double.parseDouble(n1);
            double numero2 = Double.parseDouble(n2);
            double resultado = 0;
            String operacion = "";

            int id = v.getId();

            if (id == R.id.button7) { // Suma
                resultado = numero1 + numero2;
                operacion = "Suma";
            } else if (id == R.id.button8) { // Resta
                resultado = numero1 - numero2;
                operacion = "Resta";
            } else if (id == R.id.button5) { // Multiplicación
                resultado = numero1 * numero2;
                operacion = "Multiplicación";
            } else if (id == R.id.button6) { // División
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    operacion = "División";
                } else {
                    t.setText("Error: División por cero");
                    return;
                }
            }

            t.setText("El resultado de la " + operacion + " es: " + resultado);

        } catch (NumberFormatException ex) {
            t.setText("Por favor ingresa números válidos");
        }
    }
}
