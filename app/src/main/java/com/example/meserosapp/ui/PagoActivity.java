package com.example.meserosapp.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.meserosapp.R;

public class PagoActivity extends AppCompatActivity  {

    String[] pagos= {"Mesa1","Mesa2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Pago ");


        ListView listView =(ListView) findViewById(R.id.ListPagoId);

        ListAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,pagos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog();
//              Intent intent = new Intent(PagoActivity.this,DialogPagoActivity.class);
//              intent.putExtra("detalle",pagos[position]);
//              startActivity(intent);




            }
        });

    }

    public void openDialog() {
        DialogPagoActivity dialogPago = new DialogPagoActivity();
        dialogPago.show(getSupportFragmentManager(), "Pago");
    }


    public void btnEntregarPedidoClick(View view){

        Intent intent1  = new Intent (PagoActivity.this, MenuActivity.class  );

        startActivity(intent1);


    }
}
