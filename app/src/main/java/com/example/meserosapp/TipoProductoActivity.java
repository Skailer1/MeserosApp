package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TipoProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_producto);

        getSupportActionBar().setTitle("Tipo Producto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] tipos_producto = {"Bebidas","Comidas"};
        ListView listView =(ListView) findViewById(R.id.CartegoriaListId);

        ListAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tipos_producto);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position ==0){

                    Intent intent = new Intent(TipoProductoActivity.this,ProductoActivity.class);
                    startActivity(intent);
                }


            }
        });
    }


}
