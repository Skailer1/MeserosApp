package com.example.meserosapp.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.R;

public class UsarioActivity extends AppCompatActivity  {

    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtContraseña;
    private TextView viewIsActivo;
    private TextView viewId;
    private TextView viewFechaCreacion;
    private TextView viewFechaActualizacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usario);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);

        getSupportActionBar().setTitle("Usuario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void btnTipoEmpleadoClick(View view){



         Intent intent  = new Intent (UsarioActivity.this, TipoEmpleadoActivity.class  );

        startActivity(intent);


    }



}
