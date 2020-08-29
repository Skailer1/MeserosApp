package com.example.meserosapp.ui.pedido;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.DetallePedido;



import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PedidoRecyclerAdapter extends RecyclerView.Adapter<PedidoRecyclerAdapter.ViewHolder> {

    private List<DetallePedido> detalles = new ArrayList<>();
    private final PedidoRecyclerAdapter.OnItemClickListener onItemClickListener;

    PedidoRecyclerAdapter(PedidoRecyclerAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PedidoRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_detaillist_layout, parent, false);
        return new PedidoRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoRecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(detalles.get(position), position);
    }


    @Override
    public int getItemCount() {
        return detalles.size();
    }

    void updateItems(List<DetallePedido> detalles) {
        this.detalles.clear();
        this.detalles.addAll(detalles);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(@NonNull View itemView) {
            super(itemView);




        }

        void bind(DetallePedido detalle, int position) {



            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(detalle, position));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DetallePedido detalle, int position);
    }
}
