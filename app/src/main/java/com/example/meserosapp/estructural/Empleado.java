package com.example.meserosapp.estructural;

import java.util.Date;
import java.util.List;

public class Empleado
{
    private Long id;
    private String nombre;
    private long telefono;
    private String correo;
    private String direccion;
    private boolean esActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Documento documento;
    private TipoEmpleado tipoEmpleado;
    private Usuario usuarioId;
    private List<Mesa> mesaList;

    public Empleado(Long id, String nombre, long telefono, String correo, String direccion, boolean esActivo, Date fechaCreacion, Date fechaActualizacion, Documento documento, TipoEmpleado tipoEmpleado, Usuario usuarioId, List<Mesa> mesaList) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.esActivo = esActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.documento = documento;
        this.tipoEmpleado = tipoEmpleado;
        this.usuarioId = usuarioId;
        this.mesaList = mesaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }
}

