package com.example.meserosapp.estructural;

import com.example.meserosapp.enums.TipoImpuesto;

import java.util.List;

public class Impuesto
{
    private Long id;
    private double valor;
    private TipoImpuesto tipoImpuesto;
    private List<Pedido> pedidoList;

    public Impuesto(Long id, double valor, TipoImpuesto tipoImpuesto, List<Pedido> pedidoList) {
        this.id = id;
        this.valor = valor;
        this.tipoImpuesto = tipoImpuesto;
        this.pedidoList = pedidoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
