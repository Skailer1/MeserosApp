package com.example.meserosapp.data.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pedido
{
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("fechaPedido")
    @Expose
    private String fechaPedido;
    @SerializedName("activo")
    @Expose
    private boolean isActivo;
    @SerializedName("fechaCreacion")
    @Expose
    private String fechaCreacion;
    @SerializedName("fechaActualizacion")
    @Expose
    private String fechaActualizacion;
    @SerializedName("mesaId")
    @Expose
    private Mesa mesaId;
    @SerializedName("usuarioId")
    @Expose
    private Usuario usuarioId;
  /*  @SerializedName("estadoId")
    @Expose
    private EstadoPedido estadoId;
    @SerializedName("detalles")
    @Expose
    private List <DetallePedido> detalles;*/

    public Pedido(Long id, String fechaPedido, boolean isActivo, String fechaCreacion, String fechaActualizacion, Mesa mesaId, Usuario usuarioId) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.isActivo = isActivo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.mesaId = mesaId;
        this.usuarioId = usuarioId;
    }

    public Pedido() {

    }

    public Pedido(Mesa mesaId, Usuario usuarioId) {
        this.mesaId = mesaId;
        this.usuarioId = usuarioId;

  //      this.detalles = detalles;
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
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


    public Mesa getMesaId() {
        return mesaId;
    }

    public void setMesaId(Mesa mesaId) {
        this.mesaId = mesaId;
    }



    public Long getId() {
        return id;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setId(Long id) {
        this.id = id;
    }

  /*  public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }*/
}
