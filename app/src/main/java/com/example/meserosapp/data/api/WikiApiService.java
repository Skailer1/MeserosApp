package com.example.meserosapp.data.api;

import com.example.meserosapp.data.modelo.AuthToken;
import com.example.meserosapp.data.modelo.DetallePedido;
import com.example.meserosapp.data.modelo.Empleado;
import com.example.meserosapp.data.modelo.EstadoPedido;
import com.example.meserosapp.data.modelo.LoginRequest;
import com.example.meserosapp.data.modelo.Mesa;
import com.example.meserosapp.data.modelo.Pedido;
import com.example.meserosapp.data.modelo.Producto;
import com.example.meserosapp.data.modelo.TipoDocumento;
import com.example.meserosapp.data.modelo.TipoEmpleado;
import com.example.meserosapp.data.modelo.TipoProducto;
import com.example.meserosapp.data.modelo.Usuario;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WikiApiService {

    @POST("v1/usuario/login")
    Single<AuthToken> login(@Body LoginRequest loginRequest);

    @GET("v1/mesa")
    Single<List<Mesa>> obtenerMesas(@Header("Authorization") String authorization);

    @GET("v1/tipoProducto")
    Single<List<TipoProducto>> obtenerCategorias(@Header("Authorization") String authorization);

    @GET("v1/producto")
    Single<List<Producto>> obtenerProductos(@Header("Authorization") String authorization);

    @GET("v1/pedido")
    Single<List<Pedido>> obtenerPedidos(@Header("Authorization") String authorization);

    @GET("v1/tipoEmpleado")
    Single<List<TipoEmpleado>> obtenerRoles(@Header("Authorization") String authorization);

    @GET("v1/tipoDocumento")
    Single<List<TipoDocumento>> obtenerDocumentos(@Header("Authorization") String authorization);

    @POST("v1/empleado")
    Single<Empleado> crearEmpleado(@Body Empleado empleado, @Header("Authorization") String authorization );

    @POST("v1/usuario")
    Single<Usuario> crearUsuario(@Body Usuario usuario, @Header("Authorization") String authorization);

    @POST("v1/pedido")
    Single<Pedido> crearPedido(@Body Pedido pedido, @Header("Authorization") String authorization);

    @GET("pedido/detalle/{pedidoIdP}")
    Single<DetallePedido> obtenerDetalle(@Path("pedidoIdP") Long id, @Header("Authorization") String authorization);

    @GET("v1/estado/{id}")
    Single<EstadoPedido> obtenerEstado(@Path("id") Long id, @Header("Authorization") String authorization);

    @GET("v1/pedido/{id}")
    Single<Pedido> obtenerPedido(@Path("id") Long id, @Header("Authorization") String authorization);

    @POST("v1/detalle")
    Single<DetallePedido> detallePedido(@Body DetallePedido detalle);

    @GET("v1/producto/tipo/{tipoProductoId}")
    Single<List<Producto>> obtenerProductosPorTipo(@Path("tipoProductoId") Long tipoProductoId, @Header("Authorization") String authorization);

    @PUT("v1/estado/{id}")
    Single<EstadoPedido> actualizarEstado(@Path("id") Long id , @Body EstadoPedido estado,@Header("Authorization") String authorization );

    @DELETE("v1/pedido/{id}")
    Single <Pedido> eliminarPedido(@Path("id") Long id, @Header("Authorization") String authorization);

}
