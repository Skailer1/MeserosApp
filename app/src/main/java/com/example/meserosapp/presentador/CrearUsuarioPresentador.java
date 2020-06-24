package com.example.meserosapp.presentador;

import com.example.meserosapp.api.meseros.UsuarioApiAdapter;
import com.example.meserosapp.api.meseros.UsuarioApiClient;
import com.example.meserosapp.api.meseros.UsuarioApiListener;
import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Usuario;

public class CrearUsuarioPresentador implements CrearUsuarioContrato.Presentador
{
    private UsuarioApiClient apiClient;
    private CrearUsuarioContrato.Vista vista;

    public CrearUsuarioPresentador() {
        apiClient = new UsuarioApiClient(crearListener());
    }

    @Override
    public void crear() {
    Usuario usuario = new Usuario();

        usuario.setNombreUsuario(vista.darNombreUsuario());
    //    usuario.setId(vista.darId());
        usuario.setCorreo(vista.darCorreo());
        usuario.setContraseña(vista.darContraseña());
      //  usuario.setIsActivo(vista.darIsActivo());
      //  usuario.setFechaCreacion(vista.darFechaCreacion());
      //  usuario.setFechaActualizacion(vista.darFechaActualizacion());
        apiClient.crear(usuario);

    }

    @Override
    public void agregarVista(CrearUsuarioContrato.Vista vista) {
        this.vista = vista;
    }

    private UsuarioApiListener crearListener() {
        return new UsuarioApiAdapter() {

            @Override
            public void enCrearUsuarioCorrecto(Usuario reserva) {
                super.enCrearUsuarioCorrecto(reserva);
                vista.mostrarMensaje("Usuario creado");
            }

            @Override
            public void enCrearUsuarioError(BaseResponse response) {
                super.enCrearUsuarioError(response);
                vista.mostrarMensaje(response.getMensaje());
            }
        };
    }
}
