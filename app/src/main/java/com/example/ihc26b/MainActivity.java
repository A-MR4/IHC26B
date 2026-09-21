package com.example.ihc26b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText e;
    private TextView t;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        // Configuración del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilitar JavaScript

        // Forzar la apertura de enlaces en WebView en lugar del navegador
        webView.setWebViewClient(new WebViewClient());

        // Cargar una página web
        webView.loadUrl("https://www.google.com");
        t = findViewById(R.id.textView);
        e = findViewById(R.id.editTextText);
        
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

        // Modern and fully compatible back button handler for web views
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    setEnabled(false);
                    onBackPressed();
                }
            }
        });
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
            intent = new Intent(MainActivity.this, Opcion.class);
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