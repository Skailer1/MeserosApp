package com.example.meserosapp.estructural;

import com.example.meserosapp.enums.RH;
import com.example.meserosapp.enums.Sexo;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class TipoDocumento
{
    private Long id;
    private String descripcionDocumento;
    private boolean isActivo;
    private LocalTime fechaCreacion;
    private Date fechaActualizacion;


    public TipoDocumento(Long id, String descripcionDocumento, boolean isActivo, LocalTime fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.descripcionDocumento = descripcionDocumento;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}