package com.example.meserosapp.presentador;

import com.example.meserosapp.api.meseros.TipoEmpleadoApiAdapter;
import com.example.meserosapp.api.meseros.TipoEmpleadoApiClient;
import com.example.meserosapp.api.meseros.TipoEmpleadoApiListener;
import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoEmpleado;

import java.util.List;

public class ListarTipoEmpleadoPresentador implements ListartTipoEmpleadoContrato.Presentador {

    private TipoEmpleadoApiClient apiClient;
    private ListartTipoEmpleadoContrato.Vista vista;

    public ListarTipoEmpleadoPresentador() {
        apiClient = new TipoEmpleadoApiClient(crearListener());
    }

    @Override
    public void listarTodos() {

        apiClient.listarTodos();

    }


    @Override
    public void agregarVista(ListartTipoEmpleadoContrato.Vista vista) {
        this.vista = vista;

    }

    private TipoEmpleadoApiListener crearListener() {
        return new TipoEmpleadoApiAdapter() {
            @Override
            public void enObtenerTipoEmpleadoCorrecto(List<TipoEmpleado> tipoEmpleados) {
                super.enObtenerTipoEmpleadoCorrecto(tipoEmpleados);
                vista.mostrarTodos(tipoEmpleados);
            }

            @Override
            public void enObtenerTipoEmpleadoError(BaseResponse response) {
                super.enObtenerTipoEmpleadoError(response);
                vista.mostrarMensaje(response.getMensaje());
            }
        };
    }
}
