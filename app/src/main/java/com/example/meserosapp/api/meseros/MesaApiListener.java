package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Mesa;

import java.util.List;

public interface MesaApiListener
{
    void enObtenerMesaCorrecto(Mesa mesas);

    void enObtenerMesasCorrecto(List<Mesa> mesas);

    void enObtenerMesaError(BaseResponse response);

    void enObtenerMesasError(BaseResponse response);
}
