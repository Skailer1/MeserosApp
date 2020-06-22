package com.example.meserosapp.estructural;

import com.example.meserosapp.enums.RH;
import com.example.meserosapp.enums.Sexo;
import com.example.meserosapp.enums.TipoDocumento;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Documento
{
    private Long id;
    private TipoDocumento tipoDocumento;
    private long numeroDocumento;
    private Date fechaExpedicion;
    private String ciudad;
    private Date fechaNacimiento;
    private Sexo sexo;
    private RH rh;
    private boolean esActivo;
    private LocalTime fechaCreacion;
    private Date fechaActualizacion;
    private List<Empleado> empleadoList;

    public Documento(Long id, TipoDocumento tipoDocumento, long numeroDocumento, Date fechaExpedicion, String ciudad, Date fechaNacimiento, Sexo sexo, RH rh, boolean esActivo, LocalTime fechaCreacion, Date fechaActualizacion, List<Empleado> empleadoList) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaExpedicion = fechaExpedicion;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.rh = rh;
        this.esActivo = esActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.empleadoList = empleadoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public RH getRh() {
        return rh;
    }

    public void setRh(RH rh) {
        this.rh = rh;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public LocalTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }
}
