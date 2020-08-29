package com.example.meserosapp.ui.registro;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.TipoEmpleado;
import com.example.meserosapp.data.modelo.Usuario;
import com.example.meserosapp.data.singleton.Singleton;
import com.example.meserosapp.ui.MenuActivity;
import com.example.meserosapp.ui.login.LoginActivity;
import com.example.meserosapp.ui.tipoEmpleado.TipoEmpleadoActivity;

public class RegistroActivity extends AppCompatActivity  {

    private EditText txtNombreUsuario;
    private EditText txtTelefono;
    private EditText txtDireccion;
    private EditText txtNumeroDocumento;
    private EditText txtRh;
    private EditText txtSexo;
    private EditText txtTipoDocumento;
    private EditText txtTipoEmpleado;
    private Spinner tipoEmpleadoList;
    private Singleton singleton;
    private TextView usuarioId;
    private RegistroViewModel registroViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombreUsuario = findViewById(R.id.txtEmpleado);
        txtDireccion =  findViewById(R.id.txtDireccion);
        txtTelefono =  findViewById(R.id.txtTelefono);
        txtNumeroDocumento =  findViewById(R.id.txtNumeroDocumento);
        txtRh =  findViewById(R.id.txtRh);
        txtSexo =  findViewById(R.id.txtSexo);
        txtTipoDocumento =  findViewById(R.id.txtTipoDocumento);
        txtTipoEmpleado =  findViewById(R.id.txtTipoEmpleado);
        tipoEmpleadoList = findViewById(R.id.spinnerEmpleado);
        singleton = Singleton.obtenerInstancia();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registro");
        registroViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
        observableViewModel();


        usuarioId = findViewById(R.id.usuario);

        Bundle idExtraido = this.getIntent().getExtras();

        if (idExtraido != null){
            Long id = idExtraido.getLong("id");
            usuarioId.setText(String.valueOf(id));
        }

    }

    private void observableViewModel() {
        registroViewModel.getEmpleado().observe(this, empleado -> {
            if (empleado != null) {
               // singleton.getUsuarioId();
                Toast.makeText(this, "Se ha creado un nuevo empleado", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent (RegistroActivity.this, MenuActivity.class  );
                startActivity(intent);
                finish();

            }
        });

        registroViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void btnSesionClick(View view){



        registroViewModel.crearEmpleado( txtNombreUsuario.getText().toString(),
                Long.parseLong(txtTelefono.getText().toString()), txtRh.getText().toString(),
                txtSexo.getText().toString(), txtTipoDocumento.getText().toString(),
                txtTipoEmpleado.getText().toString(), Long.parseLong(txtNumeroDocumento.getText().toString()),
                txtDireccion.getText().toString()) ;


    }



}
