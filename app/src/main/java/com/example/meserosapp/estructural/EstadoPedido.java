package com.example.meserosapp.estructural;

import com.example.meserosapp.enums.DescripcionEstado;

import java.util.List;

public class EstadoPedido
{
    private Long id;
    private DescripcionEstado descripcionEstado;
    private List<Pedido> pedidoList;

    public EstadoPedido(Long id, DescripcionEstado descripcionEstado, List<Pedido> pedidoList) {
        this.id = id;
        this.descripcionEstado = descripcionEstado;
        this.pedidoList = pedidoList;
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

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
