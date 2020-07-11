package com.example.meserosapp.ui.tipoproducto;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.TipoProducto;
import com.example.meserosapp.ui.producto.ProductoActivity;

public class TipoProductoActivity extends AppCompatActivity implements TipoProductoRecyclerAdapter.OnItemClickListener{

    private TipoProductoViewModel tipoProductoViewModel;
    private TipoProductoRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_producto);
        RecyclerView categorias = findViewById(R.id.tipoProductoList);
        categorias.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TipoProductoRecyclerAdapter(this);
        categorias.setAdapter(adapter);
        tipoProductoViewModel = new ViewModelProvider(this).get(TipoProductoViewModel.class);
        tipoProductoViewModel.obtenerCategorias();
        observableViewModel();
        getSupportActionBar().setTitle("Tipo Producto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void observableViewModel() {
        tipoProductoViewModel.getCategorias().observe(this, categorias -> {
            if (categorias != null) {
                adapter.updateItems(categorias);
            }
        });

        tipoProductoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(TipoProducto tipoProducto, int position) {
        Intent intent = new Intent(TipoProductoActivity.this, ProductoActivity.class);
        startActivity(intent);
    }

}



































  /*   String[] tipos_producto = {"Bebidas","Comidas"};
        ListView listView =(ListView) findViewById(R.id.CartegoriaListId);

        ListAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tipos_producto);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position ==0){

                    Intent intent = new Intent(TipoProductoActivity.this, ProductoActivity.class);
                    startActivity(intent);
                }


            }
        }); */