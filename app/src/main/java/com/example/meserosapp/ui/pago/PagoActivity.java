package com.example.meserosapp.ui.pago;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.request.Http;
import com.example.meserosapp.ui.MenuActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class PagoActivity extends AppCompatActivity implements PagoRecyclerAdapter.OnItemClickListener  {

   // private Button refrescar;
    private PagoViewModel pagoViewModel;
    private PagoRecyclerAdapter adapter;
    private Dialog customDialog;
    private TextView detalleTxt;
    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
    private Http http;
    private JSONObject eliminar = new JSONObject();
    private JSONObject listarPorId = new JSONObject();
    private JSONArray listaDetalles = new JSONArray();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
     //   detalleTxt= findViewById(R.id.detalleId);
      //  refrescar = findViewById(R.id.refrescarId);
        configShared = getSharedPreferences("configShared", Context.MODE_PRIVATE);
        editorConfig = configShared.edit();
        RecyclerView pedidos = findViewById(R.id.pagoList);
        pedidos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PagoRecyclerAdapter(this);
        pedidos.setAdapter(adapter);
        pagoViewModel = new ViewModelProvider(this).get(PagoViewModel.class);
        pagoViewModel.obtenerPedidos();
        observableViewModel();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pago ");

     /*   refrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagoViewModel.getPedidos().observe(PagoActivity.this, pedidos -> {
                    if (pedidos != null) {
                        adapter.updateItems(pedidos);
                    }
                });

                pagoViewModel.getError().observe(PagoActivity.this, error -> {
                    if (error != null) {
                        Toast.makeText(PagoActivity.this, error.getMensaje(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



*/


    }

    private void observableViewModel() {
        pagoViewModel.getPedidos().observe(this, pedidos -> {
            if (pedidos != null) {
                adapter.updateItems(pedidos);
            }
        });

        pagoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendGetHttp(){



        try {
            listarPorId.put("detalles",listaDetalles);
            http = new Http("listByOrder",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""), listarPorId,2);
            //   http.setId(Long.parseLong(configShared.getString("id","")));
            //   http.setId(99L);

            String response =  http.execute().get();
            System.out.println(response);

        }catch (Exception e){

        }

    }


    public void almacenarJSON (){


        try {

           // JSONArray listaDetalles = new JSONArray();

            for (int i = 0; i<listaDetalles.length(); i++){
                JSONObject detalle = listaDetalles.getJSONObject(i);


                detalle.put("nombreProducto","");
                detalle.put("fechaCreacion","");
                detalle.put("cantidad","");
                detalle.put("valorUnitario","");
                detalle.put("total","");



            }






        } catch (Exception e){

        }
    }


    public void sendHttp(){


        try {
            eliminar.put("codigoEstado","");
            eliminar.put("mensaje", "");
            eliminar.put("correcto","");
            http = new Http("deleteOrder",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""), eliminar,3);
            //   http.setId(Long.parseLong(configShared.getString("id","")));
            //   http.setId(99L);

            String response =  http.execute().get();
            System.out.println(response);

        }catch (Exception e){

        }

    }


    @Override
    public void onItemClick(Pedido pedido, int position) {

     //   editorConfig.putString("id",pedido.getId().toString());
     //   editorConfig.commit();

        openDialog();
    }




    public void btnEntregarPedidoClick(View view){

        Intent intent1  = new Intent (PagoActivity.this, MenuActivity.class  );

        startActivity(intent1);


    }


    public void btnRefrescarPedidoClick(View view){

        finish();
        startActivity(getIntent());

    }




    public void openDialog() {
        DialogPagoActivity dialogPago = new DialogPagoActivity(PagoActivity.this);
        dialogPago.show(getSupportFragmentManager(), "Pago");
    }

}




     /*   customDialog = new Dialog(PagoActivity.this);
        customDialog.setContentView(R.layout.activity_dialog_pago);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        getView(String.valueOf(pedido.getId()));

        customDialog.show();*/




   /* private void getView(String message){
        detalleTxt = customDialog.findViewById(R.id.detalleId);
        detalleTxt.setText(message);
    }*/





























     /*   ListView listView =(ListView) findViewById(R.id.ListPagoId);

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


    }*/
