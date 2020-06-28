package com.example.meserosapp.ui;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Mesa;
import java.util.ArrayList;
import java.util.List;

public class MesasActivity extends AppCompatActivity  {

    private ListView listaMesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);
        listaMesas = findViewById(R.id.MesasListId);
        getSupportActionBar().setTitle("Mesas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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