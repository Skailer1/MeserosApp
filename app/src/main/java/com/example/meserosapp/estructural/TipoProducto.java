package com.example.meserosapp.estructural;

import java.util.List;

public class TipoProducto
{
    private Long id;
    private String descripcion;
    private List<Producto> productoList;

    public TipoProducto(Long id, String descripcion, List<Producto> productoList) {
        this.id = id;
        this.descripcion = descripcion;
        this.productoList = productoList;
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

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
