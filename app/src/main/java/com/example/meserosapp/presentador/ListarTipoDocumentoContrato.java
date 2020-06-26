package com.example.meserosapp.presentador;

import com.example.meserosapp.estructural.TipoDocumento;

import java.util.List;

public interface ListarTipoDocumentoContrato {

    interface Vista extends BaseVista{

        void mostrarTodos (List<TipoDocumento> tipoDocumentos);

    }
    interface Presentador extends BasePresentador<ListarTipoDocumentoContrato.Vista>
    {
        void listarTodos();

    }

}
