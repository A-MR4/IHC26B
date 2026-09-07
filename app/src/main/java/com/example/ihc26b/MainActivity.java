package com.example.ihc26b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText e;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textView);
        e = findViewById(R.id.editTextText);
        
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Show the toast immediately when ANY button is clicked
        Toast.makeText(getApplicationContext(), "Botón presionado", Toast.LENGTH_SHORT).show();

        String nombre = e.getText().toString();
        t.setText(getString(R.string.welcome_message, nombre));

        Intent intent = null;
        int id = v.getId();
        
        if (id == R.id.button) {
            //intent = new Intent(MainActivity.this, Inicio.class);
        } else if (id == R.id.button2) {
            intent = new Intent(MainActivity.this, Pag2.class);
        } else if (id == R.id.button3) {
            intent = new Intent(MainActivity.this, Pag3.class);
        } else if (id == R.id.button4) {
            intent = new Intent(MainActivity.this, Pag4.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}