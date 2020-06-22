package com.example.meserosapp.estructural;

import java.util.List;

public class Usuario
{
    private Long id;
    private String nombreUsuario;
    private String correo;
    private String contraseña;
    private boolean esActivo;
    private List<Rol> rolList;
    private List<Empleado> empleadoList;

    public Usuario(Long id, String nombreUsuario, String correo, String contraseña, boolean esActivo, List<Rol> rolList, List<Empleado> empleadoList) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.esActivo = esActivo;
        this.rolList = rolList;
        this.empleadoList = empleadoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }
}
