package com.example.meserosapp.ui.pedido;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.DetallePedido;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.request.Http;
import com.example.meserosapp.ui.MainActivity;
import com.example.meserosapp.ui.MenuActivity;
import com.example.meserosapp.ui.mesa.MesaRecyclerAdapter;
import com.example.meserosapp.ui.mesa.MesasActivity;
import com.example.meserosapp.ui.pago.PagoActivity;
import com.example.meserosapp.ui.producto.CustomProductParacelable;
import com.example.meserosapp.ui.producto.ProductoActivity;
import com.example.meserosapp.ui.tipoproducto.TipoProductoActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PedidoActivity extends AppCompatActivity  {

    private Button notificacion;
  /*  private PedidoRecyclerAdapter adapter;
    private PedidoViewModel pedidoViewModel;*/
    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
    private ArrayList<String> detallePedidos;
    private LinearLayout detallePedidoP;
    private Double total;
    private Http http;
    private JSONArray contenedor = new JSONArray();
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        notificacion = findViewById(R.id.btnFinalizarPedido);
        detallePedidos =  new ArrayList<String>();
        detallePedidoP = findViewById(R.id.detallesPedidoP);
        total = 0.0;
        configShared = getSharedPreferences("configShared", Context.MODE_PRIVATE);
        editorConfig = configShared.edit();
        getSupportActionBar().setTitle("Pedidos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String objetos = configShared.getString("detalles","");
        try {
            contenedor = new JSONArray(objetos);
            setView();
            System.out.println("recibido de productos" + contenedor);
        } catch (JSONException e) {
            System.out.println(e);
        }
        // Toast.makeText(this, "detalles"+ configShared, Toast.LENGTH_SHORT).show();
        System.out.println(configShared);


        FirebaseMessaging.getInstance().subscribeToTopic("mesas").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(PedidoActivity.this,"Suscrito a mesas",Toast.LENGTH_SHORT).show();
            }
        });

        notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarNotificacion();
                httpSend();
                Toast.makeText(PedidoActivity.this,"Se ha realizado un nuevo pedido",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(PedidoActivity.this, ProductoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finishAffinity();
                startActivity(intent);
                finish();
            }
        });


    }

    private void enviarNotificacion() {
        RequestQueue myrequest = Volley.newRequestQueue(getApplicationContext());
        JSONObject json = new JSONObject();

        //   String token = "fBnDqw78QoqgMZvVBfOZoO:APA91bEMRVpG3f2WjupUMwCSwUe8HVNHKTLxD6CjQADP4VwqeffT-0XoVA2pafU5gXFzKX_F4TSkxnjz7pm7wCbo_ob6ajsPAmGmfCW3kiR8P6b3pTKElt0-yiyxf9ddjVHsR1RSzQrP";

        try {
            json.put("to","/topics/"+ "cocina");
            JSONObject notificacionJ = new JSONObject();
            notificacionJ.put("titulo", "Nuevo Pedido");
            notificacionJ.put("detalle", "Se ha realizado un nuevo pedido");

            json.put("data", notificacionJ);

            String URL = "https://fcm.googleapis.com/fcm/send";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,URL,json, null,null){
                @Override
                public Map<String, String> getHeaders()  {
                    Map<String,String > header = new HashMap<>();
                    header.put("content-type", "application/json");
                    header.put("authorization","key=AAAAeqJqPjc:APA91bEmoCj-8tLNPp4izDHS8BjxTMbCxoeA3f7Di_aduP-nt0ZVWxgtF0PTVffWm06-s7c6aIquTTtNv-UvvgZmT1oj_ojsZmdBrWkUEuR0By7EswN64-BA_Tw-OkjW4coU5QQNMMEn");
                    return header;

                }
            };
            myrequest.add(request);
        }catch (JSONException e){

        }


    }

    private void setView (){
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



    }



    private void mostrarDetalles(){
        detallePedidos.add("detalles del pedido"+ configShared.getString("detalles",""));
    }



    public void btnAgregarPedidoClick(View view){



        Intent intent  = new Intent (PedidoActivity.this, ProductoActivity.class  );

        startActivity(intent);

    }

    private void httpSend(){
        try{
            JSONObject pedido = new JSONObject(configShared.getString("pedidoTotal", ""));
            http = new Http("addProduct",preferencesManager.getAuthToken().replace("Bearer", "").replace(" ", ""),pedido,1, "");
            String response =  http.execute().get();
            System.out.println("response "+response);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void btnFinalizarPedidoClick(View view){

    //    pedidoViewModel.crearPedido();




    }

}

















 /*  pedidoViewModel = new ViewModelProvider(this).get(PedidoViewModel.class);
        observableViewModel();*/



/*
    @Override
    public void onItemClick(DetallePedido detalle, int position) {
        Intent intent = new Intent(PedidoActivity.this, PedidoActivity.class);
        startActivity(intent);
    }


 */

/*

    //    ArrayList<DetallePedido> lista = (ArrayList<DetallePedido>) getIntent().getSerializableExtra("milista");

   //     if(lista!= null){
   //         Toast.makeText(this, "detalles"+ lista.size(), Toast.LENGTH_SHORT).show();


     //   }

      /*  Intent intent = getIntent();
        CustomProductParacelable paracelable = intent.getParcelableExtra("Example Item");
         String nombreProducto = paracelable.getNombreProducto();
         Long productoId = paracelable.getProductoId();

        TextView fechaId = findViewById(R.id.fechaId);
        fechaId.setText(nombreProducto);

        TextView pedidoId = findViewById(R.id.pedidoId);
        pedidoId.setText(String.valueOf(productoId));*/











/*    private void observableViewModel() {
        pedidoViewModel.getPedido().observe(this, pedido -> {
            if (pedido != null) {
                Toast.makeText(this, "Se ha creado un nuevo pedido", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent (PedidoActivity.this, MenuActivity.class  );
                startActivity(intent);
                finish();

            }
        });

        pedidoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/