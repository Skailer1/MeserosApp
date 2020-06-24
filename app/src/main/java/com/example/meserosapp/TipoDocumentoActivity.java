package com.example.meserosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TipoDocumentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_documento);
        getSupportActionBar().setTitle("Tipo Documento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
