package com.example.meserosapp.ui.mesa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.TipoProducto;
import com.example.meserosapp.ui.pedido.PedidoActivity;
import com.example.meserosapp.ui.producto.ProductoActivity;
import com.example.meserosapp.ui.tipoproducto.TipoProductoActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MesasActivity extends AppCompatActivity implements MesaRecyclerAdapter.OnItemClickListener {

    private MesaViewModel mesaViewModel;
    private MesaRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);
        RecyclerView mesas = findViewById(R.id.tableList);
        mesas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MesaRecyclerAdapter(this);
        mesas.setAdapter(adapter);
        mesaViewModel = new ViewModelProvider(this).get(MesaViewModel.class);
        mesaViewModel.obtenerMesas();
        observableViewModel();
        getSupportActionBar().setTitle("Mesas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void observableViewModel() {
        mesaViewModel.getMesas().observe(this, mesas -> {
            if (mesas != null) {
                adapter.updateItems(mesas);
            }
        });

        mesaViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(Mesa mesa, int position) {
        Intent intent = new Intent(MesasActivity.this, ProductoActivity .class);
        startActivity(intent);
    }
}
















  /* String[] mesas= {"Mesa1","Mesa2","Mesa3","Mesa4","Mesa5","Mesa6","Mesa7","Mesa8","Mesa9","Mesa10","Mesa11","Mesa12"};
        ListView listView =(ListView) findViewById(R.id.MesasListId);

        ListAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mesas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position ==0){

                    Intent intent = new Intent(MesasActivity.this,PedidoActivity.class);
                    startActivity(intent);
                }


            }
        });*/