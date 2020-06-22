package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
}
