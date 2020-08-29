package com.example.meserosapp.ui.producto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import  android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.example.meserosapp.R;

public class CantidadProductoDialogActivity extends AppCompatDialogFragment {

    private EditText cantidadProducto;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_cantidad_producto_dialog, null);
        builder.setView(view)
                .setTitle("Cantidad Producto")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int cantidad = Integer.parseInt(cantidadProducto.getText().toString());


                    }
                });

        cantidadProducto = view.findViewById(R.id.cantidad);
        return builder.create();
    }


}