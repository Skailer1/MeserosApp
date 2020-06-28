package com.example.meserosapp.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.enums.RH;
import com.example.meserosapp.data.enums.Sexo;
import com.example.meserosapp.ui.login.LoginActivity;

public class RegistroActivity extends AppCompatActivity  {

    private EditText txtNombreUsuario;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private EditText txtDireccion;
    private EditText txtNumeroDocumento;
    private EditText txtRh;
    private EditText txtSexo;
    private EditText txtUsuario;
    private EditText txtTipoDocumento;
    private EditText txtTipoEmpleado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtNombreUsuario = (EditText) findViewById(R.id.txtNombreUsua);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtNumeroDocumento = (EditText) findViewById(R.id.txtNumeroDocumento);
        txtRh = (EditText) findViewById(R.id.txtRh);
        txtSexo = (EditText) findViewById(R.id.txtSexo);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtTipoDocumento = (EditText) findViewById(R.id.txtTipoDocumento);
        txtTipoEmpleado = (EditText) findViewById(R.id.txtTipoEmpleado);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registro");

    }

    public void btnSesionClick(View view){



        Intent intent  = new Intent (RegistroActivity.this, LoginActivity.class  );

        startActivity(intent);
//amigo y como le muestro?

    }



}
