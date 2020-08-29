package com.example.meserosapp.ui.tipoEmpleado;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.TipoEmpleado;
import com.example.meserosapp.ui.registro.RegistroActivity;

public class TipoEmpleadoActivity extends AppCompatActivity {

    private TipoEmpleadoViewModel tipoEmpleadoViewModel;
    private Spinner tipoEmpleadoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empleado);
        tipoEmpleadoList =  findViewById(R.id.spinnerEmpleado);
        tipoEmpleadoViewModel = new ViewModelProvider(this).get(TipoEmpleadoViewModel.class);
        tipoEmpleadoViewModel.obtenerRoles();
        observableViewModel();
        getSupportActionBar().setTitle("Tipo Empleado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void observableViewModel() {
        tipoEmpleadoViewModel.getRoles().observe(this, roles -> {
            if (roles != null) {
                //   adapter.updateItems(roles);
            }
        });

        tipoEmpleadoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void btnRegistroClick(View view){

        Intent intent  = new Intent (TipoEmpleadoActivity.this, RegistroActivity.class  );

        startActivity(intent);


    }
}
