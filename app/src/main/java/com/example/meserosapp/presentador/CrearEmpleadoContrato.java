package com.example.meserosapp.presentador;

import com.example.meserosapp.enums.RH;
import com.example.meserosapp.enums.Sexo;
import com.example.meserosapp.enums.TipoDocumentoEnum;
import com.example.meserosapp.enums.TipoEmpleadoEnum;
import com.example.meserosapp.estructural.TipoDocumento;
import com.example.meserosapp.estructural.TipoEmpleado;
import com.example.meserosapp.estructural.Usuario;

import java.util.Date;

public interface CrearEmpleadoContrato {

    interface Vista extends BaseVista {
      //  Long darId();
        String darNombre();
        Long darTelefono();
        String darCorreo();
        String darDireccion();
        RH darRh();
        Sexo darSexo();
        Long darNumeroDocumento();
        /*  boolean darActivo();
        Date darFechaCreacion();
        Date darFechaActualizacion();
        TipoEmpleado darTipoEmpleado();
        TipoDocumento darTipoDocumento();
        Usuario darUsuario();*/
    }



    interface Presentador extends BasePresentador<Vista> {

        void crear();

    }
}
