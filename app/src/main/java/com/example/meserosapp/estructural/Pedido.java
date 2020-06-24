package com.example.meserosapp.estructural;

import java.util.Date;
import java.util.List;

public class Pedido
{
    private Long id;
    private Date fechaPedido;
    private boolean isActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Empleado empleadoId;
    private Mesa mesaId;
    private EstadoPedido estadoId;

    public Pedido(Long id, Date fechaPedido, boolean isActivo, Date fechaCreacion, Date fechaActualizacion, Empleado empleadoId, Mesa mesaId, EstadoPedido estadoId) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.empleadoId = empleadoId;
        this.mesaId = mesaId;
        this.estadoId = estadoId;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Mesa getMesaId() {
        return mesaId;
    }

    public void setMesaId(Mesa mesaId) {
        this.mesaId = mesaId;
    }

    public EstadoPedido getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(EstadoPedido estadoId) {
        this.estadoId = estadoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }


}
