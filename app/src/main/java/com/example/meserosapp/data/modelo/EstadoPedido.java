package com.example.meserosapp.data.modelo;

import com.example.meserosapp.data.enums.DescripcionEstado;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstadoPedido {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("descripcionEstado")
    @Expose
    private DescripcionEstado descripcionEstado;
    @SerializedName("fechaActualizacion")
    @Expose
    private String fechaActualizacion;
    @SerializedName("fechaCreacion")
    @Expose
    private String fechaCreacion;
    @SerializedName("activo")
    @Expose
    private Boolean activo;

    public EstadoPedido(Long id, DescripcionEstado descripcionEstado, String fechaActualizacion, String fechaCreacion, Boolean activo) {
        this.id = id;
        this.descripcionEstado = descripcionEstado;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DescripcionEstado estado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(DescripcionEstado estado) {
        this.descripcionEstado = estado;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
