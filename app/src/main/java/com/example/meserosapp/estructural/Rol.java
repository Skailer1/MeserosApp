package com.example.meserosapp.estructural;

import java.util.List;

public class Rol
{
    private Long id;
    private String nombreRol;
    private String descripcion;
    private List<Usuario> usuarioList;

    public Rol(Long id, String nombreRol, String descripcion, List<Usuario> usuarioList) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.usuarioList = usuarioList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
