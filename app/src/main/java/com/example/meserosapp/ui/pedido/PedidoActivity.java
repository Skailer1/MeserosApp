package com.example.meserosapp.ui.pedido;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.MenuActivity;
import com.example.meserosapp.ui.tipoproducto.TipoProductoActivity;

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
