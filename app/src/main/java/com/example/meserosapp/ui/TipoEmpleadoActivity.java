package com.example.meserosapp.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.meserosapp.R;

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
