package com.example.meserosapp.presentador;

import com.example.meserosapp.api.meseros.TipoDocumentoApiAdapter;
import com.example.meserosapp.api.meseros.TipoDocumentoApiClient;
import com.example.meserosapp.api.meseros.TipoDocumentoApiListener;
import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoDocumento;

import java.util.List;

public class ListarTipoDocumentoPresentador implements ListarTipoDocumentoContrato.Presentador{

    private TipoDocumentoApiClient apiClient;
    private ListarTipoDocumentoContrato.Vista vista;

    public ListarTipoDocumentoPresentador() {
        apiClient = new TipoDocumentoApiClient(crearListener());
    }

    @Override
    public void listarTodos() {

        apiClient.listarTodos();

    }


    @Override
    public void agregarVista(ListarTipoDocumentoContrato.Vista vista) {
        this.vista = vista;

    }

    private TipoDocumentoApiListener crearListener() {
        return new TipoDocumentoApiAdapter() {
            @Override
            public void enObtenerTipoDocumentoCorrecto(List<TipoDocumento> tipoDocumentos) {
                super.enObtenerTipoDocumentoCorrecto(tipoDocumentos);
                vista.mostrarTodos(tipoDocumentos);
            }

            @Override
            public void enObtenerTipoDocumentoError(BaseResponse response) {
                super.enObtenerTipoDocumentoError(response);
                vista.mostrarMensaje(response.getMensaje());
            }
        };
    }


}
