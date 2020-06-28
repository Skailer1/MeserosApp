package com.example.meserosapp.data.modelo;

import java.util.Date;

public class TipoProducto
{
    private Long id;
    private String descripcion;
    private boolean isActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;


    public TipoProducto(Long id, String descripcion, boolean isActivo, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
