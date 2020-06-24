package com.example.meserosapp.api.meseros;

import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Usuario;

public interface UsuarioApiListener
{

    void enCrearUsuarioCorrecto(Usuario usuario);

    void enCrearUsuarioError(BaseResponse response);
}
