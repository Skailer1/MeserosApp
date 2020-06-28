package com.example.meserosapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meserosapp.R;

public class TipoDocumentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_documento);
        getSupportActionBar().setTitle("Tipo Documento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
