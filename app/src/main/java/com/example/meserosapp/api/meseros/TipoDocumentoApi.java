package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.TipoDocumento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TipoDocumentoApi {

    @GET("tipoDocumento")
    Call<List<TipoDocumento>> listarTodos();
}
