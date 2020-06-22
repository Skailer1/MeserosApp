package com.example.meserosapp.presentador;

import android.content.Context;

public interface BaseVista
{
    Context getContext();

    void mostrarMensaje(String mensaje);
}
