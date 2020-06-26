package com.example.meserosapp.presentador;

import com.example.meserosapp.estructural.TipoEmpleado;

import java.util.List;

public interface ListartTipoEmpleadoContrato {

    interface Vista extends BaseVista{

        void mostrarTodos (List<TipoEmpleado> tipoEmpleados);

    }
    interface Presentador extends BasePresentador<ListartTipoEmpleadoContrato.Vista>
    {
        void listarTodos();

    }
}
