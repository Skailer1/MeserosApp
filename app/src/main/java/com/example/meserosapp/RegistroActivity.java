package com.example.meserosapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meserosapp.enums.RH;
import com.example.meserosapp.enums.Sexo;
import com.example.meserosapp.enums.TipoDocumentoEnum;
import com.example.meserosapp.enums.TipoEmpleadoEnum;
import com.example.meserosapp.estructural.TipoDocumento;
import com.example.meserosapp.estructural.TipoEmpleado;
import com.example.meserosapp.estructural.Usuario;
import com.example.meserosapp.presentador.CrearEmpleadoContrato;
import com.example.meserosapp.presentador.CrearEmpleadoPresentador;

public class RegistroActivity extends AppCompatActivity implements CrearEmpleadoContrato.Vista {

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
    private CrearEmpleadoContrato.Presentador presentador;


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
        presentador = new CrearEmpleadoPresentador();
        presentador.agregarVista(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registro");

    }

    public void btnSesionClick(View view){

        presentador.crear();

        Intent intent  = new Intent (RegistroActivity.this, LoginActivity.class  );

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

       @Override
    public TipoDocumento darTipoDocumento() {

        return  TipoDocumento;
    }

    @Override
    public TipoEmpleado darTipoEmpleado() {
        return TipoEmpleado;
    }

    @Override
    public Usuario darUsuario() {
        return Usuario;
    }


*/

    @Override
    public String darNombre() {
        return txtNombreUsuario.getText().toString();
    }

    @Override
    public String darCorreo() {
        return txtCorreo.getText().toString();
    }

    @Override
    public String darDireccion() {
        return txtDireccion.getText().toString();
    }
    @Override
    public RH darRh() {
        return RH.A_NEGATIVO;
    }

    @Override
    public Sexo darSexo() {
        return Sexo.FEMENINO;
    }
    @Override
    public Long darNumeroDocumento(){
        return Long.parseLong(txtNumeroDocumento.getText().toString());

    }

    @Override
    public Long darTelefono(){
        return Long.parseLong(txtTelefono.getText().toString());

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
