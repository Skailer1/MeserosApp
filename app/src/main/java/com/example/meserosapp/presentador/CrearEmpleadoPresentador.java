package com.example.meserosapp.presentador;

import com.example.meserosapp.api.meseros.EmpleadoApiAdapter;
import com.example.meserosapp.api.meseros.EmpleadoApiClient;
import com.example.meserosapp.api.meseros.EmpleadoApiListener;
import com.example.meserosapp.estructural.BaseResponse;
import com.example.meserosapp.estructural.Empleado;

public class CrearEmpleadoPresentador implements CrearEmpleadoContrato.Presentador {

    private EmpleadoApiClient apiClient;
    private CrearEmpleadoContrato.Vista vista;

    public CrearEmpleadoPresentador() {
        apiClient = new EmpleadoApiClient(crearListener());
    }

    @Override
    public void crear() {
        Empleado empleado = new Empleado();
    //    empleado.setId(vista.darId());
        empleado.setNombre(vista.darNombre());
        empleado.setCorreo(vista.darCorreo());
        empleado.setDireccion(vista.darDireccion());
        empleado.setNumeroDocumento(vista.darNumeroDocumento());
        empleado.setTelefono(vista.darTelefono());
        empleado.setRh(vista.darRh());
        empleado.setSexo(vista.darSexo());
       /* empleado.setActivo(vista.darActivo());
        empleado.setFechaActualizacion(vista.darFechaActualizacion());
        empleado.setFechaCreacion(vista.darFechaCreacion());
        empleado.setDocumento(vista.darTipoDocumento());
        empleado.setTipoEmpleado(vista.darTipoEmpleado());
        empleado.setUsuarioId(vista.darUsuario());*/
        apiClient.crear(empleado);
    }


    @Override
    public void agregarVista(CrearEmpleadoContrato.Vista vista) {
        this.vista = vista;
    }

    private EmpleadoApiListener crearListener() {
        return new EmpleadoApiAdapter() {

            @Override
            public void enCrearEmpleadoCorrecto(Empleado empleado) {
                super.enCrearEmpleadoCorrecto(empleado);
                vista.mostrarMensaje("Empleado creado");
            }

            @Override
            public void enCrearEmpleadoError(BaseResponse response) {
                super.enCrearEmpleadoError(response);
                vista.mostrarMensaje(response.getMensaje());
            }
        };
    }
}
