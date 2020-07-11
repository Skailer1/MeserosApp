package com.example.meserosapp.ui.pago;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PagoRecyclerAdapter  extends RecyclerView.Adapter<PagoRecyclerAdapter.ViewHolder>
{
    private List<Pedido> pedidos = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;

    PagoRecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_orderslist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pedidos.get(position), position);

    }


    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    void updateItems(List<Pedido> pedidos) {
        this.pedidos.clear();
        this.pedidos.addAll(pedidos);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtOrderId /*, txtNombreProducto, txtCosto, txtCantidadStock*/;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtOrderId = itemView.findViewById(R.id.txtOrderId);
         //   txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
         //   txtCosto = itemView.findViewById(R.id.txtCosto);
         //   txtCantidadStock = itemView.findViewById(R.id.txtCantidadStock);
        }

        void bind(Pedido pedido, int position) {
            txtOrderId.setText(String.valueOf(pedido.getId()));
           // txtNombreProducto.setText(producto.getNombreProducto());
           // txtCosto.setText(String.valueOf(producto.getCosto()));
           // txtCantidadStock.setText(String.valueOf(producto.getCantidadEnStock()));
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(pedido, position));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Pedido pedido, int position);
    }
}
