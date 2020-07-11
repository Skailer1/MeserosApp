package com.example.meserosapp.data.singleton;

public class Singleton {

    private static Singleton instancia;
    private Long usuarioId;

    private Singleton() {
    }

    public synchronized static Singleton obtenerInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
