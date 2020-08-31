package com.example.meserosapp.ui.producto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.TipoProducto;

public class DialogCategoryActivity extends AppCompatDialogFragment{

 //   RadioGroup radioGroup;
 //   private TipoProductoViewModel tipoProductoViewModel;
 //   private TipoProductoRecyclerAdapter adapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_category, null);

    //    radioGroup = findViewById(R.id.radioGroupCategorias);
  //      setOnchangeRadioGroupListener();
        builder.setView(view)
                .setTitle("Categorias")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });



        return builder.create();
    }


 /*   private void setOnchangeRadioGroupListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtnTodos) {
                  productoViewModel.obtenerProductos();
                } else if (checkedId == R.id.radioBtnComidas) {
                    productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnBebidas) {
                         productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnCafeteria) {
                   productoViewModel.obtenerProductosPorTipo();
                } else if (checkedId == R.id.radioBtnDesayuno) {
                   productoViewModel.obtenerProductosPorTipo();
                }
            }
        });
    }
*/

}









    /*    RecyclerView categorias =  view.findViewById(R.id.tipoProductoList);
        categorias.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TipoProductoRecyclerAdapter(this);
        categorias.setAdapter(adapter);
        tipoProductoViewModel = new ViewModelProvider(this).get(TipoProductoViewModel.class);
        tipoProductoViewModel.obtenerCategorias();
        observableViewModel();*/

/*private void observableViewModel() {
        tipoProductoViewModel.getCategorias().observe(this, categorias -> {
            if (categorias != null) {
                adapter.updateItems(categorias);
            }
        });

        tipoProductoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(getContext(), error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void mostrarTodos(List<Reserva> reservas) {
        List<String> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            String toString = "Cedula " + reserva.getCedula() + "\n"
                    + "Nombre: " + reserva.getNombre();
            resultado.add(toString);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultado);
        listaReservas.setAdapter(adapter);
    }

    @Override
    public void onItemClick(TipoProducto tipoProducto, int position) {

    }*/