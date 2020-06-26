package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.TipoEmpleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TipoEmpleadoApi {
    @GET("tipoEmpleado")
    Call<List<TipoEmpleado>> listarTodos();
}
