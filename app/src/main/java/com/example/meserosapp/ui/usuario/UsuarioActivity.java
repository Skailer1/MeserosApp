package com.example.meserosapp.ui.usuario;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.tipoEmpleado.TipoEmpleadoActivity;

public class UsuarioActivity extends AppCompatActivity  {

    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtContrasenia;
    private UsuarioViewModel usuarioViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usario);
        txtNombre =  findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContrasenia =  findViewById(R.id.txtContrasenia);
        getSupportActionBar().setTitle("Usuario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
        observableViewModel();
    }


    private void observableViewModel() {
        usuarioViewModel.getUsuario().observe(this, usuario -> {
            if (usuario != null) {
                Toast.makeText(this, "Se ha creado un nuevo usuario", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent (UsuarioActivity.this, TipoEmpleadoActivity.class  );
                startActivity(intent);
                finish();

            }
        });

        usuarioViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


   public void btnTipoEmpleadoClick (View view ) {


        usuarioViewModel.crearUsuario(  txtNombre.getText().toString(),
                       txtCorreo.getText().toString(),  txtContrasenia.getText().toString());

    }



}
