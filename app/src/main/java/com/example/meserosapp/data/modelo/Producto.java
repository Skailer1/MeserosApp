package com.example.meserosapp.data.modelo;

import java.util.Date;

public class Producto
{
    private Long id;
    private int cantidadEnStock;
    private String fotoProducto;
    private double iva;
    private double costo;
    private Date fechaCreación;
    private Date fechaActualizacion;
    private String nombreProducto;
    private Boolean isActivo;
    private TipoProducto tipoProducto;

    public Producto(Long id, int cantidadEnStock, String fotoProducto, double iva, double costo, Date fechaCreación, Date fechaActualizacion, String nombreProducto, Boolean isActivo, TipoProducto tipoProducto) {
        this.id = id;
        this.cantidadEnStock = cantidadEnStock;
        this.fotoProducto = fotoProducto;
        this.iva = iva;
        this.costo = costo;
        this.fechaCreación = fechaCreación;
        this.fechaActualizacion = fechaActualizacion;
        this.nombreProducto = nombreProducto;
        this.isActivo = isActivo;
        this.tipoProducto = tipoProducto;
    }

    public String getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(String fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(Date fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(Boolean isActivo) {
        this.isActivo = isActivo;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

}
