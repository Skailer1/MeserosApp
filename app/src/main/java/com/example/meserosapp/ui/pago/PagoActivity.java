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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.request.Http;
import com.example.meserosapp.ui.MenuActivity;
import com.example.meserosapp.ui.pedido.PedidoActivity;

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
    private JSONArray tempPedido = new JSONArray();
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

    private void sendGetHttp(Pedido pedido){



        try {
            editorConfig.putString("idPedido", pedido.getId().toString());
            editorConfig.commit();
            http = new Http("listByOrder",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""), listarPorId,1,pedido.getId().toString());
            //   http.setId(Long.parseLong(configShared.getString("id","")));
            //   http.setId(99L);

            String response =  http.execute().get();
            almacenarJSON(response);
            System.out.println("preurahsudfasdf"+response);

        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void almacenarJSON (String pintar){




        try {

            listaDetalles = new JSONArray(pintar);



            for (int i = 0; i<listaDetalles.length(); i++){
                JSONObject productoTemp = new JSONObject();
               // System.out.println(listaDetalles.get(i));
                JSONObject detalle = (JSONObject) listaDetalles.get(i);

                JSONObject producto = new JSONObject(detalle.getString("producto"));
                productoTemp.put("nombre",producto.getString("nombreProducto") );
                productoTemp.put("cantidad", detalle.getString("cantidad"));
                productoTemp.put("valor", detalle.getString("valorUnitario"));
                productoTemp.put("total",detalle.getString("total"));
                tempPedido.put(productoTemp);

                System.out.println(producto.getString("nombreProducto"));
                System.out.println(detalle.getString("cantidad"));
                System.out.println(detalle.getString("valorUnitario"));
                System.out.println(detalle.getString("total"));


                detalle.put("nombreProducto","");
                detalle.put("fechaCreacion","");
                detalle.put("cantidad","");
                detalle.put("valorUnitario","");
                detalle.put("total","");



            }

            //editorConfig.putString("todo", tempPedido.toString());
            //editorConfig.commit();
            openDialog();
        } catch (Exception e){
            System.out.println(e);
        }
    }


   /* private void setView (){
        try{
            LinearLayout totalPago = new LinearLayout(PedidoActivity.this);
            totalPago.setOrientation(LinearLayout.HORIZONTAL);
            TextView totalNeto = new TextView(PedidoActivity.this);
            totalNeto.setText("Total: ");
            TextView totalNeto2 = new TextView(PedidoActivity.this);
            for (int i = 0; i<contenedor.length(); i++) {
                try {
                    JSONObject object = new JSONObject(contenedor.getString(i));
                    JSONObject detalle = new JSONObject(object.getString("detalle"));

                    System.out.println("recibidos" + contenedor.getString(i));

                    LinearLayout producto = new LinearLayout(PedidoActivity.this);
                    producto.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout productoCantidad = new LinearLayout(PedidoActivity.this);
                    productoCantidad.setOrientation(LinearLayout.HORIZONTAL);


                    TextView name= new TextView(PedidoActivity.this);
                    TextView textCantidad = new TextView(PedidoActivity.this);
                    textCantidad.setText("Cantidad: ");
                    name.setText("Nombre: ");
                    TextView nombre = new TextView(PedidoActivity.this);
                    nombre.setText(object.getString("nombre"));
                    TextView cantidad = new TextView(PedidoActivity.this);
                    cantidad.setText(detalle.getString("cantidad"));

                    total += Double.parseDouble(String.valueOf(Integer.parseInt(detalle.getString("cantidad"))*Integer.parseInt(detalle.getString("valorUnitario"))));

                    //TextView valorUnitario = new TextView(PedidoActivity.this);

                    producto.addView(name);
                    producto.addView(nombre);
                    productoCantidad.addView(textCantidad);
                    productoCantidad.addView(cantidad);
                    detallePedidoP.addView(producto);
                    detallePedidoP.addView(productoCantidad);
                    //detallePedidoP.addView(cantidad);
                    //detallePedidoP.addView(valorUnitario);
                }
                catch (Exception e){
                    System.out.println(e);

                }
            }
            totalNeto2.setText(String.valueOf(total));
            totalPago.addView(totalNeto);
            totalPago.addView(totalNeto2);
            detallePedidoP.addView(totalPago);
        }catch (Exception e){
            System.out.println(e);
        }



    }*/



    public void sendHttp(){


        try {
      /*      eliminar.put("codigoEstado","");
            eliminar.put("mensaje", "");
            eliminar.put("correcto","");*/
            String idPedido = configShared.getString("idPedido", "");
            http = new Http("deleteOrder",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""), eliminar,3,idPedido);
            //   http.setId(Long.parseLong(configShared.getString("id","")));
               //http.setId("99");

            String response =  http.execute().get();
            System.out.println(response);

        }catch (Exception e){

        }

    }


    @Override
    public void onItemClick(Pedido pedido, int position) {

     //   editorConfig.putString("id",pedido.getId().toString());
     //   editorConfig.commit();
        tempPedido = new JSONArray();
        sendGetHttp(pedido);

     //   openDialog();
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
        DialogPagoActivity dialogPago = new DialogPagoActivity(PagoActivity.this, tempPedido);
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
