package com.example.meserosapp.ui.producto;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.DetallePedido;
import com.example.meserosapp.data.modelo.Producto;
import com.example.meserosapp.ui.pedido.PedidoActivity;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity implements ProductoRecyclerAdapter.OnItemClickListener{

    private ProductoViewModel productoViewModel;
    private ProductoRecyclerAdapter adapter;
   // private ArrayList<CustomProductParacelable> paracelables;

   // RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    //    radioGroup = findViewById(R.id.radioGroupCategorias);
    //    setOnchangeRadioGroupListener();
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

      //  ArrayList<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
      //  DetallePedido detalle1 = new DetallePedido(3, 2, 3L);
       // detallePedidos.add(detalle1);


      //  Intent intent  = new Intent (ProductoActivity.this, PedidoActivity.class  );
        //intent.putExtra("miLista", detallePedidos);
      /*  intent.putExtra("Example Item", paracelables.get(position));
        startActivity(intent);*/

      openDialog();
    }

    public void btnAgregarProductoClick(View view){

        Intent intent1  = new Intent (ProductoActivity.this, PedidoActivity.class  );

        startActivity(intent1);


    }

    public void btnFiltrarClick(View view){

    openDialogCategorias();


    }

    public void openDialog() {
        CantidadProductoDialogActivity dialogCantidad = new CantidadProductoDialogActivity();
        dialogCantidad.show(getSupportFragmentManager(), "Cantidad" );
    }

    public void openDialogCategorias() {
        DialogCategoryActivity dialogCategoria = new DialogCategoryActivity();
        dialogCategoria.show(getSupportFragmentManager(), "Categorias" );
    }


   /* private void setOnchangeRadioGroupListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtnTodos) {
                  productoViewModel.obtenerProductos();
                } else if (checkedId == R.id.radioBtnComidas) {
                    productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnBebidas) {
                         productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnCafeteria) {
                   productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnDesayuno) {
                   productoViewModel.obtenerProductosPorTipo();
                }
            }
        });
    }*/






}
