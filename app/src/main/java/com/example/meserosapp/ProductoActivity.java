package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        getSupportActionBar().setTitle("Productos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void btnAgregarProductoClick(View view){

        Intent intent1  = new Intent (ProductoActivity.this, PedidoActivity.class  );

        startActivity(intent1);


    }
}
