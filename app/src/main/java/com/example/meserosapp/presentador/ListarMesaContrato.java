package com.example.meserosapp.presentador;

import com.example.meserosapp.estructural.Mesa;

import java.util.List;

public interface ListarMesaContrato
{
    interface Vista extends BaseVista{

        void mostrarTodos (List<Mesa> mesas);

    }
    interface Presentador extends BasePresentador<ListarMesaContrato.Vista>
    {
        void listarTodos();

    }
}
