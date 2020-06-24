package com.example.meserosapp.estructural;

import com.example.meserosapp.enums.DescripcionEstado;

import java.util.Date;
import java.util.List;

public class EstadoPedido
{
    private Long id;
    private DescripcionEstado descripcionEstado;
    private boolean isActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    public EstadoPedido(Long id, DescripcionEstado descripcionEstado, boolean isActivo, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.descripcionEstado = descripcionEstado;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DescripcionEstado getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(DescripcionEstado descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
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
}
