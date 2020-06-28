package com.example.meserosapp.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.meserosapp.R;

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
