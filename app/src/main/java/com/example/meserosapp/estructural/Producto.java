package com.example.meserosapp.estructural;

import java.util.Date;
import java.util.List;

public class Producto
{
    private Long id;
    private int cantidadEnStock;
    private double costo;
    private Date fechaCreación;
    private Date fechaActualizacion;
    private String nombreProducto;
    private Boolean esActivo;
    private TipoProducto tipoProducto;
    private List<DetallePedido> detallePedidoList;

    public Producto(Long id, int cantidadEnStock, double costo, Date fechaCreación, Date fechaActualizacion, String nombreProducto, Boolean esActivo, TipoProducto tipoProducto, List<DetallePedido> detallePedidoList) {
        this.id = id;
        this.cantidadEnStock = cantidadEnStock;
        this.costo = costo;
        this.fechaCreación = fechaCreación;
        this.fechaActualizacion = fechaActualizacion;
        this.nombreProducto = nombreProducto;
        this.esActivo = esActivo;
        this.tipoProducto = tipoProducto;
        this.detallePedidoList = detallePedidoList;
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

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }
}
