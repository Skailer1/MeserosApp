package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoEmpleado;

import java.util.List;

public interface TipoEmpleadoApiListener {

    void enObtenerTipoEmpleadoCorrecto(List<TipoEmpleado> tipoEmpleados);

    void enObtenerTipoEmpleadoError(BaseResponse response);
}
