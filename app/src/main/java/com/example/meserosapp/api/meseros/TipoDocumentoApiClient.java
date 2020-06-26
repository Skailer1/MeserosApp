package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoDocumento;
import com.example.meserosapp.util.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipoDocumentoApiClient {

    private TipoDocumentoApi tipoDcumentoApi;
    private TipoDocumentoApiListener apiListener;

    public TipoDocumentoApiClient(TipoDocumentoApiListener tipoDocumentoApiListener) {
        tipoDcumentoApi = ApiUtil.obtenerRetrofit().create(TipoDocumentoApi.class);
        this.apiListener = tipoDocumentoApiListener;
    }

    public void listarTodos() {

        tipoDcumentoApi.listarTodos().enqueue(new Callback<List<TipoDocumento>>() {
            @Override
            public void onResponse(Call<List<TipoDocumento>> call, Response<List<TipoDocumento>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    apiListener.enObtenerTipoDocumentoCorrecto(response.body());
                } else {
                    apiListener.enObtenerTipoDocumentoError(new BaseResponse("Verifique la informacion enviada", false));
                }
            }

            @Override
            public void onFailure(Call<List<TipoDocumento>> call, Throwable t) {
                apiListener.enObtenerTipoDocumentoError(new BaseResponse("Error al consumir el servicio", false));
            }
        });
    }
}
