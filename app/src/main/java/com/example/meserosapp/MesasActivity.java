package com.example.meserosapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.meserosapp.estructural.Mesa;
import com.example.meserosapp.presentador.ListarMesaContrato;
import com.example.meserosapp.presentador.ListarMesaPresentador;

import java.util.ArrayList;
import java.util.List;

public class MesasActivity extends AppCompatActivity implements ListarMesaContrato.Vista {

    private ListView listaMesas;
    private ListarMesaContrato.Presentador presentador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);
        listaMesas = findViewById(R.id.MesasListId);
        presentador = new ListarMesaPresentador();
        presentador.agregarVista(this);
        presentador.listarTodos();
        getSupportActionBar().setTitle("Mesas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
    @Override
    public void mostrarTodos (List< Mesa > mesas) {
        List<String> resultado = new ArrayList<>();
        for (Mesa mesa : mesas) {
            String toString = "Id " + mesa.getId() + "\n"
                    + "Nombre: " + mesa.getNombre() + "\n"
                    + "Fecha Actualizacion: " + mesa.getFechaActualizacion() + "\n"
                    + "Fecha Creacion: " + mesa.getFechaCreacion() + "\n"
                    + "Es Activo: " + mesa.isActivo() ;
            resultado.add(toString);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultado);
        listaMesas.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void mostrarMensaje(String mensaje) {

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