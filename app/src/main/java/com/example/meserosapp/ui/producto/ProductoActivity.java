package com.example.meserosapp.ui.producto;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.MesappApplication;
import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Producto;
import com.example.meserosapp.data.preferences.SharedPreferencesManager;
import com.example.meserosapp.data.request.Http;
import com.example.meserosapp.ui.pedido.PedidoActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity implements ProductoRecyclerAdapter.OnItemClickListener {

    private ProductoViewModel productoViewModel;
    private ProductoRecyclerAdapter adapter;
    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
    private TextView viewCategory;
    private Integer cantidad;
    private Producto productos;
    private SharedPreferencesManager preferencesManager = MesappApplication.obtenerSharedPreferencesManager();
    private JSONArray detallePedidos;
    private Http http;
    private JSONObject productoDetalle = new JSONObject();
    private JSONObject pedido = new JSONObject();
    private ArrayList<JSONObject> contenedorDetalle = new ArrayList<JSONObject>();
    private JSONObject temporalObjetos = new JSONObject();

   // private ArrayList<CustomProductParacelable> paracelables;

   // RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    //    radioGroup = findViewById(R.id.radioGroupCategorias);
    //    setOnchangeRadioGroupListener();
        configShared = getSharedPreferences("configShared", Context.MODE_PRIVATE);
        editorConfig = configShared.edit();
        viewCategory = findViewById(R.id.viewCategory);
        productos = null;
        cantidad = 0;
        detallePedidos = new JSONArray ();
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

    private void sendHttp(){

        try {
            pedido.put("mesaId", configShared.getString("mesaId",""));
            pedido.put("usuarioId",configShared.getString("usuarioId",""));
          //  String tempDetalle="";
            //JSONArray tempDetail = new JSONArray(detallePedidos);
            //for (int i=0; i<detallePedidos.size(); i++){
           // pedido.put("detalles",detallePedidos.get(i));
              //  tempDetalle += detallePedidos.get(i) + ",";
            //}
            pedido.put("detalles",detallePedidos);
          //  System.out.println("concatenacion "+ tempDetalle);
            System.out.println(pedido);
            http = new Http("addProduct",preferencesManager.getAuthToken(),pedido,1);
            String response =  http.execute().get();
            System.out.println(response);
        }catch (Exception e){

        }

    }

    public void almacenarJson (){

        try {
            JSONObject detalles = new JSONObject();
            productoDetalle.put("producto", productos.getId());
          //  productoDetalle.put("nombre", productos.getNombreProducto());
            detalles.put("cantidad",getCantidad());
            detalles.put("valorUnitario", productos.getCosto());
         //   detalles.put("subtotal", productos.getCosto()* getCantidad());
            productoDetalle.put("detalle",detalles);
          //  detallePedidos.put(productoDetalle);
            contenedorDetalle.add(productoDetalle);
            System.out.println("lista" + contenedorDetalle);
            detallePedidos = new JSONArray(contenedorDetalle);
            System.out.println(productoDetalle);
       //     detallePedidos.add("{'producto':"+productos.getId()+",'detalle':"+productoDetalle.getString("detalle")+"}");
/*            productoDetalle.put("detalle", "{'cantidad':"+getCantidad()
                    +",'costo':"+productos.getCosto()+"}");

*/          System.out.println(pedido);
            //System.out.println(detallePedidos);

            //detallePedido.put("product",producto.getId() + producto.getCosto() + producto.getCosto());
        } catch (Exception e){

        }
    }

    @Override
    public void onItemClick(Producto producto, int position) {

        this.productos = producto;
      //  Toast.makeText(this, "el id es: "+ producto.getId() + "\n" + producto.getCosto() + "\n" + producto.getNombreProducto() , Toast.LENGTH_SHORT).show();


        openDialog();
        System.out.println(getCantidad());


        //ArrayList<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
      //  DetallePedido detalle1 = new DetallePedido(3, 2, 3L);
     //   detallePedidos.add();
        /*editorConfig.putString("id","");
        editorConfig.putString("costo","");
        editorConfig.putString("nombre","");
        editorConfig.commit();*/





      //  Intent intent  = new Intent (ProductoActivity.this, PedidoActivity.class  );
        //intent.putExtra("miLista", detallePedidos);
      /*  intent.putExtra("Example Item", paracelables.get(position));
        startActivity(intent);*/

    }

    public void btnAgregarProductoClick(View view){
        Intent intent1  = new Intent (ProductoActivity.this, PedidoActivity.class  );
        editorConfig.putString("detalles",detallePedidos.toString());
        editorConfig.commit();
        startActivity(intent1);

        sendHttp();


    }

    public void btnFiltrarClick(View view){

    openDialogCategorias();


    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void openDialog() {
        CantidadProductoDialogActivity dialogCantidad = new CantidadProductoDialogActivity(ProductoActivity.this);
        dialogCantidad.show(getSupportFragmentManager(), "Cantidad" );

    }

    public void openDialogCategorias() {
        DialogCategoryActivity dialogCategoria = new DialogCategoryActivity();
        dialogCategoria.show(getSupportFragmentManager(), "Categorias" );
    }

   /* @Override
    public void applyTexts(int cantidad) {
        viewCategory.setText(cantidad);


        }*/



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