package com.example.meserosapp.ui.producto;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Producto;
import com.example.meserosapp.ui.DialogPagoActivity;
import com.example.meserosapp.ui.pedido.PedidoActivity;

public class ProductoActivity extends AppCompatActivity implements ProductoRecyclerAdapter.OnItemClickListener{

    private ProductoViewModel productoViewModel;
    private ProductoRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        RecyclerView productos = findViewById(R.id.productosList);
        productos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductoRecyclerAdapter(this);
        productos.setAdapter(adapter);
        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);
        productoViewModel.obtenerProductos();
        observableViewModel();
        getSupportActionBar().setTitle("Productos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void observableViewModel() {
        productoViewModel.getProductos().observe(this, productos -> {
            if (productos != null) {
                adapter.updateItems(productos);
            }
        });

        productoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(Producto producto, int position) {
        Intent intent = new Intent(ProductoActivity.this, PedidoActivity.class);
        startActivity(intent);
    }

    public void btnAgregarProductoClick(View view){

        Intent intent1  = new Intent (ProductoActivity.this, PedidoActivity.class  );

        startActivity(intent1);


    }


}
