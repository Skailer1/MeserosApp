package com.example.meserosapp.ui.registro;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.R;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.request.Http;
import com.example.meserosapp.data.singleton.Singleton;
import com.example.meserosapp.ui.MenuActivity;
import com.example.meserosapp.ui.login.LoginActivity;
import com.example.meserosapp.ui.usuario.UsuarioActivity;

import org.json.JSONObject;

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
    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
    private JSONObject empleadoNuevo = new JSONObject();
    private JSONObject empleado = new JSONObject();
    private Http http;
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        configShared = getSharedPreferences("configShared", Context.MODE_PRIVATE);
        editorConfig = configShared.edit();
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


        configShared.getString("usuarioId","");
        System.out.println(configShared);

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

    private void sendHttp(){

        try {
            empleadoNuevo.put("usuarioId",configShared.getString("usuarioId",""));
            empleadoNuevo.put("empleado",empleado);
            System.out.println(empleadoNuevo);
            http = new Http("createEmployee",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""), empleadoNuevo,1);
            http.setId(3L);
            String response =  http.execute().get();
            System.out.println(response);
        }catch (Exception e){

        }

    }

    public void almacenarJson (){

        try {
            empleado.put("nombre",txtNombreUsuario.getText().toString());
            empleado.put("telefono",Long.parseLong(txtTelefono.getText().toString()));
            empleado.put("rh",txtRh.getText().toString());
            empleado.put("sexo", txtSexo.getText().toString());
            empleado.put("tipoDocumento",txtTipoDocumento.getText().toString());
            empleado.put("tipoEmpleado",txtTipoEmpleado.getText().toString());
            empleado.put("numeroDocumento",Long.parseLong(txtNumeroDocumento.getText().toString()));
            empleado.put("direccion",txtDireccion.getText().toString());





        } catch (Exception e){

        }
    }




    public void btnSesionClick(View view){

        almacenarJson();
        sendHttp();
        if (empleadoNuevo != null){
            Toast.makeText(this, "Se ha creado un nuevo empleado", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent (RegistroActivity.this, LoginActivity.class  );
            startActivity(intent);


        }


      /*  registroViewModel.crearEmpleado( txtNombreUsuario.getText().toString(),
                Long.parseLong(txtTelefono.getText().toString()), txtRh.getText().toString(),
                txtSexo.getText().toString(), txtTipoDocumento.getText().toString(),
                txtTipoEmpleado.getText().toString(), Long.parseLong(txtNumeroDocumento.getText().toString()),
                txtDireccion.getText().toString()) ;*/



    }



}
