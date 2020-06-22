package com.example.meserosapp.presentador;

import com.example.meserosapp.api.meseros.MesaApiAdapter;
import com.example.meserosapp.api.meseros.MesaApiClient;
import com.example.meserosapp.api.meseros.MesaApiListener;
import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Mesa;

import java.util.List;

public class ListarMesaPresentador implements ListarMesaContrato.Presentador
{
    private MesaApiClient apiClient;
    private ListarMesaContrato.Vista vista;

    public ListarMesaPresentador() {
        apiClient = new MesaApiClient(crearListener());
    }

    @Override
    public void listarTodos() {

        apiClient.listarTodos();

    }


    @Override
    public void agregarVista(ListarMesaContrato.Vista vista) {
        this.vista = vista;

    }

    private MesaApiListener crearListener() {
        return new MesaApiAdapter() {
            @Override
            public void enObtenerMesasCorrecto(List<Mesa> mesas) {
                super.enObtenerMesasCorrecto(mesas);
                vista.mostrarTodos(mesas);
            }

            @Override
            public void enObtenerMesasError(BaseResponse response) {
                super.enObtenerMesasError(response);
                vista.mostrarMensaje(response.getMensaje());
            }
        };
    }

}
