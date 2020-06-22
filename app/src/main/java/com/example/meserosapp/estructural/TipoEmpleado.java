package com.example.meserosapp.estructural;

import java.util.Date;
import java.util.List;

public class TipoEmpleado
{
    private Long id;
    private String nombre;
    private boolean esActivo;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private List<Empleado> empleadoList;

    public TipoEmpleado(Long id, String nombre, boolean esActivo, Date fechaCreacion, Date fechaActualizacion, List<Empleado> empleadoList) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }
}
