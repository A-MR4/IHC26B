package com.example.ihc26b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int id = v.getId();
        
        if (id == R.id.button) {
            intent = new Intent(MainActivity.this, Inicio.class);
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