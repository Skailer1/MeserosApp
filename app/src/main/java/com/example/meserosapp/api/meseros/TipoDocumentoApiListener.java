package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.TipoDocumento;

import java.util.List;

public interface TipoDocumentoApiListener {

    void enObtenerTipoDocumentoCorrecto(List<TipoDocumento> tipoDocumentos);

    void enObtenerTipoDocumentoError(BaseResponse response);
}
