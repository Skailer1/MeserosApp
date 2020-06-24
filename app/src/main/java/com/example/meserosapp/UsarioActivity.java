package com.example.meserosapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.estructural.TipoEmpleado;
import com.example.meserosapp.presentador.CrearUsuarioContrato;
import com.example.meserosapp.presentador.CrearUsuarioPresentador;

import java.util.Date;

public class UsarioActivity extends AppCompatActivity implements CrearUsuarioContrato.Vista {

    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtContraseña;
    private TextView viewIsActivo;
    private TextView viewId;
    private TextView viewFechaCreacion;
    private TextView viewFechaActualizacion;
    private CrearUsuarioContrato.Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usario);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        presentador = new CrearUsuarioPresentador();
        presentador.agregarVista(this);
        getSupportActionBar().setTitle("Usuario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void btnTipoEmpleadoClick(View view){

        presentador.crear();

         Intent intent  = new Intent (UsarioActivity.this, TipoEmpleadoActivity.class  );

        startActivity(intent);


    }


 /*   @Override
    public Long darId() {
        return darId();
    }

    @Override
    public boolean darIsActivo() {
        return darIsActivo();
    }

    @Override
    public Date darFechaCreacion() {
        return darFechaCreacion();
    }

    @Override
    public Date darFechaActualizacion() {
        return darFechaActualizacion() ;
    }

*/
    @Override
    public String darNombreUsuario() {
        return txtNombre.getText().toString();
    }


    @Override
    public String darCorreo() {
        return txtCorreo.getText().toString();
    }

    @Override
    public String darContraseña() {
        return txtContraseña.getText().toString();
    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

}
