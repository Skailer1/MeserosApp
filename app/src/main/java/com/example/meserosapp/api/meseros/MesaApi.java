package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.Mesa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MesaApi
{
    @GET("mesa")
    Call<List<Mesa>> listarTodos();



}
