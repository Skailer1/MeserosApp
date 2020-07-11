package com.example.meserosapp.ui.tipoDocumento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meserosapp.R;

public class TipoDocumentoActivity extends AppCompatActivity{


    private TipoDocumentoViewModel tipoDocumentoViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_documento);
        tipoDocumentoViewModel = new ViewModelProvider(this).get(TipoDocumentoViewModel.class);
        tipoDocumentoViewModel.obtenerDocumentos();
        observableViewModel();
        getSupportActionBar().setTitle("Tipo Documento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void observableViewModel() {
        tipoDocumentoViewModel.getDocumentos().observe(this, documentos -> {
            if (documentos != null) {
                //   adapter.updateItems(roles);
            }
        });

        tipoDocumentoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
