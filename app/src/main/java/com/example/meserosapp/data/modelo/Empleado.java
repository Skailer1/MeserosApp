package com.example.meserosapp.data.modelo;

import com.example.meserosapp.data.enums.RH;
import com.example.meserosapp.data.enums.Sexo;

import java.util.Date;

public class Empleado
{
    private Long id;
    private String nombre;
    private long telefono;
    private String correo;
    private String direccion;
    private RH rh;
    private Sexo sexo;
    private Long numeroDocumento;
    private boolean isActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private TipoDocumento documento;
    private TipoEmpleado tipoEmpleado;
    private Usuario usuarioId;


    public Empleado(Long id, String nombre, long telefono, String correo, String direccion, RH rh, Sexo sexo, Long numeroDocumento, boolean isActivo, Date fechaCreacion, Date fechaActualizacion, TipoDocumento documento, TipoEmpleado tipoEmpleado, Usuario usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.rh = rh;
        this.sexo = sexo;
        this.numeroDocumento = numeroDocumento;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.documento = documento;
        this.tipoEmpleado = tipoEmpleado;
        this.usuarioId = usuarioId;
    }

    public Empleado (){

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

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        this.isActivo = activo;
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

    public TipoDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(TipoDocumento documento) {
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

    public RH getRh() {
        return rh;
    }

    public void setRh(RH rh) {
        this.rh = rh;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}

