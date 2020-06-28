package com.example.meserosapp.data.api;

import com.example.meserosapp.data.modelo.AuthToken;
import com.example.meserosapp.data.modelo.LoginRequest;
import com.example.meserosapp.data.modelo.Mesa;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WikiApiService {

    @POST("v1/usuario/login")
    Single<AuthToken> login(@Body LoginRequest loginRequest);

    @GET("v1/mesa")
    Single<List<Mesa>> obtenerMesas(@Header("Authorization") String authorization);
}
