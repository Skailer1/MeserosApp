package com.example.meserosapp.ui.tipoEmpleado;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.meserosapp.data.modelo.TipoEmpleado;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class TipoEmpleadoAdapter extends ArrayAdapter {
    private List<TipoEmpleado> roles = new ArrayList<>();


    public TipoEmpleadoAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
