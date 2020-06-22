package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Mesa;
import com.example.meserosapp.util.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MesaApiClient
{
    private MesaApi mesaApi;
    private MesaApiListener apiListener;

    public MesaApiClient(MesaApiListener mesaApiListener) {
        mesaApi = ApiUtil.obtenerRetrofit().create(MesaApi.class);
        this.apiListener = mesaApiListener;
    }


    public void listarTodos() {

        mesaApi.listarTodos().enqueue(new Callback<List<Mesa>>() {
            @Override
            public void onResponse(Call<List<Mesa>> call, Response<List<Mesa>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    apiListener.enObtenerMesasCorrecto(response.body());
                } else {
                    apiListener.enObtenerMesasError(new BaseResponse("Verifique la informacion enviada", false));
                }
            }

            @Override
            public void onFailure(Call<List<Mesa>> call, Throwable t) {
                apiListener.enObtenerMesasError(new BaseResponse("Error al consumir el servicio", false));
            }
        });
    }
}
