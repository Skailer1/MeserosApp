package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoEmpleado;
import com.example.meserosapp.util.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipoEmpleadoApiClient {

    private TipoEmpleadoApi tipoEmpleadoApi;
    private TipoEmpleadoApiListener apiListener;

    public TipoEmpleadoApiClient(TipoEmpleadoApiListener tipoEmpleadoApiListener) {
        tipoEmpleadoApi = ApiUtil.obtenerRetrofit().create(TipoEmpleadoApi.class);
        this.apiListener = tipoEmpleadoApiListener;
    }

    public void listarTodos() {

        tipoEmpleadoApi.listarTodos().enqueue(new Callback<List<TipoEmpleado>>() {
            @Override
            public void onResponse(Call<List<TipoEmpleado>> call, Response<List<TipoEmpleado>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    apiListener.enObtenerTipoEmpleadoCorrecto(response.body());
                } else {
                    apiListener.enObtenerTipoEmpleadoError(new BaseResponse("Verifique la informacion enviada", false));
                }
            }

            @Override
            public void onFailure(Call<List<TipoEmpleado>> call, Throwable t) {
                apiListener.enObtenerTipoEmpleadoError(new BaseResponse("Error al consumir el servicio", false));
            }
        });
    }
}
