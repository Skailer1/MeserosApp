package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipoEmpleadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empleado);
        getSupportActionBar().setTitle("Tipo Empleado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void btnRegistroClick(View view){

        Intent intent  = new Intent (TipoEmpleadoActivity.this, RegistroActivity.class  );

        startActivity(intent);


    }
}
