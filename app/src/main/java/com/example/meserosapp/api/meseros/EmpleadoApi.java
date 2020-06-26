package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.Empleado;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EmpleadoApi {
    @POST("usuario")
    Call<Empleado> crear(@Body Empleado empleado);
}
