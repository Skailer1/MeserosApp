package com.example.meserosapp.presentador;

public interface BasePresentador  <V extends BaseVista>
{
    void agregarVista(V vista);
}
