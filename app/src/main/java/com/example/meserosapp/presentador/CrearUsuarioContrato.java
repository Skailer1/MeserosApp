package com.example.meserosapp.presentador;

import java.util.Date;

public interface CrearUsuarioContrato
{
    interface Vista extends BaseVista {


//        Long darId();
        String darNombreUsuario();
        String darCorreo();
        String darContraseña();
//        boolean darIsActivo();
//        Date darFechaCreacion();
//        Date darFechaActualizacion();

    }

    interface Presentador extends BasePresentador<Vista> {

        void crear();

    }

}
