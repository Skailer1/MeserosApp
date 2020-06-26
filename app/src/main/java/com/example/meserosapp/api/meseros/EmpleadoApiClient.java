package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Empleado;
import com.example.meserosapp.util.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmpleadoApiClient
{
    private EmpleadoApi empleadoApi;
    private EmpleadoApiListener apiListener;

    public EmpleadoApiClient(EmpleadoApiListener empleadoApiListener) {
        empleadoApi = ApiUtil.obtenerRetrofit().create(EmpleadoApi.class);
        this.apiListener = empleadoApiListener;
    }

    public void crear(final Empleado empleado) {

        empleadoApi.crear(empleado).enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful() && response.code() == 201) {
                    apiListener.enCrearEmpleadoCorrecto(empleado);
                } else {
                    apiListener.enCrearEmpleadoError(new BaseResponse("Verifique la informacion enviada", false));
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                apiListener.enCrearEmpleadoError(new BaseResponse("Error al consumir el servicio", false));
            }
        });
    }
}
