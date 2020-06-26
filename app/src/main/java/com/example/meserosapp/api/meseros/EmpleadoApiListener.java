package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Empleado;

public interface EmpleadoApiListener {
    void enCrearEmpleadoCorrecto(Empleado empleado);

    void enCrearEmpleadoError(BaseResponse response);
}
