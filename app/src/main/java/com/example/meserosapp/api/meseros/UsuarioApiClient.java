package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Usuario;
import com.example.meserosapp.util.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioApiClient
{
    private UsuarioApi usuarioApi;
    private UsuarioApiListener apiListener;

    public UsuarioApiClient(UsuarioApiListener usuarioApiListener) {
        usuarioApi = ApiUtil.obtenerRetrofit().create(UsuarioApi.class);
        this.apiListener = usuarioApiListener;
    }

    public void crear(final Usuario usuario) {

        usuarioApi.crear(usuario).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful() && response.code() == 201) {
                    apiListener.enCrearUsuarioCorrecto(usuario);
                } else {
                    apiListener.enCrearUsuarioError(new BaseResponse("Verifique la informacion enviada", false));
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                apiListener.enCrearUsuarioError(new BaseResponse("Error al consumir el servicio", false));
            }
        });
    }
}
