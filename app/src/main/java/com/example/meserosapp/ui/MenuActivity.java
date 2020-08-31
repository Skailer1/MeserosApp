package com.example.meserosapp.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.mesa.MesasActivity;
import com.example.meserosapp.ui.pago.PagoActivity;
import com.example.meserosapp.ui.registro.RegistroActivity;
import com.example.meserosapp.ui.usuario.UsuarioActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void btnMesasActivityClick(View view){

        Intent intent1  = new Intent (MenuActivity.this, MesasActivity.class  );

        startActivity(intent1);


    }
    public void btnPagoActivityClick(View view){

        Intent intent2  = new Intent (MenuActivity.this, PagoActivity.class  );

        startActivity(intent2);


    }

    public void btnRegistroActivityClick(View view){

        Intent intent  = new Intent (MenuActivity.this, UsuarioActivity.class  );

        startActivity(intent);


    }
}
