package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        getSupportActionBar().setTitle("Pedidos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void btnAgregarPedidoClick(View view){

        Intent intent1  = new Intent (PedidoActivity.this, TipoProductoActivity.class  );

        startActivity(intent1);


    }

    public void btnFinalizarPedidoClick(View view){

        Intent intent1  = new Intent (PedidoActivity.this, MenuActivity.class  );

        startActivity(intent1);


    }
}
