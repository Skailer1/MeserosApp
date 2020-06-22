package com.example.meserosapp.estructural;

import java.util.List;

public class DetallePedido
{
    private Long id;
    private int cantidad;
    private double valorUnitario;
    private Producto productoId;
    private List<Pedido> pedidoList;

    public DetallePedido(Long id, int cantidad, double valorUnitario, Producto productoId, List<Pedido> pedidoList) {
        this.id = id;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.productoId = productoId;
        this.pedidoList = pedidoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
