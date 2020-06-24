package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioApi
{
    @POST("usuario")
    Call<Usuario> crear(@Body Usuario usuario);
}
