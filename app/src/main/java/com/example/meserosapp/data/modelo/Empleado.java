package com.example.meserosapp.data.modelo;

import com.example.meserosapp.data.enums.RH;
import com.example.meserosapp.data.enums.Sexo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.acl.LastOwnerException;

public class Empleado {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("telefono")
    @Expose
    private Integer telefono;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("fechaCreacion")
    @Expose
    private String fechaCreacion;
    @SerializedName("fechaActualizacion")
    @Expose
    private String fechaActualizacion;
    @SerializedName("rh")
    @Expose
    private RH rh;
    @SerializedName("numeroDocumento")
    @Expose
    private Integer numeroDocumento;
    @SerializedName("sexo")
    @Expose
    private Sexo sexo;
    @SerializedName("tipoDocumento")
    @Expose
    private TipoDocumento tipoDocumento;
    @SerializedName("usuarioId")
    @Expose
    private Usuario usuarioId;
    @SerializedName("tipoEmpleado")
    @Expose
    private TipoEmpleado tipoEmpleado;
    @SerializedName("activo")
    @Expose
    private Boolean activo;

    public Empleado(Long id, String nombre, Integer telefono,  String direccion, String fechaCreacion, String fechaActualizacion, RH rh, Integer numeroDocumento, Sexo sexo, TipoDocumento tipoDocumento, Usuario usuarioId, TipoEmpleado tipoEmpleado, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.rh = rh;
        this.numeroDocumento = numeroDocumento;
        this.sexo = sexo;
        this.tipoDocumento = tipoDocumento;
        this.usuarioId = usuarioId;
        this.tipoEmpleado = tipoEmpleado;
        this.activo = activo;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public RH getRh() {
        return rh;
    }

    public void setRh(RH rh) {
        this.rh = rh;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}