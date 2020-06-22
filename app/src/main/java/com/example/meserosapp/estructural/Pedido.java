package com.example.meserosapp.estructural;

import java.util.Date;
import java.util.List;

public class Pedido
{
    private Long id;
    private Date fechaPedido;
    private List<Mesa> mesaList;
    private List<Impuesto> impuestoList;
    private List<EstadoPedido> estadoPedidoList;
    private DetallePedido detalleId;

    public Pedido(Long id, Date fechaPedido, List<Mesa> mesaList, List<Impuesto> impuestoList, List<EstadoPedido> estadoPedidoList, DetallePedido detalleId) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.mesaList = mesaList;
        this.impuestoList = impuestoList;
        this.estadoPedidoList = estadoPedidoList;
        this.detalleId = detalleId;
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

    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }

    public List<Impuesto> getImpuestoList() {
        return impuestoList;
    }

    public void setImpuestoList(List<Impuesto> impuestoList) {
        this.impuestoList = impuestoList;
    }

    public List<EstadoPedido> getEstadoPedidoList() {
        return estadoPedidoList;
    }

    public void setEstadoPedidoList(List<EstadoPedido> estadoPedidoList) {
        this.estadoPedidoList = estadoPedidoList;
    }

    public DetallePedido getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(DetallePedido detalleId) {
        this.detalleId = detalleId;
    }
}
