package com.example.meserosapp.ui.mesa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Mesa;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MesaRecyclerAdapter extends RecyclerView.Adapter<MesaRecyclerAdapter.ViewHolder> {
    private List<Mesa> mesas = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;

    MesaRecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_tablelist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mesas.get(position), position);
        Picasso.get().load(mesas.get(position).getImagenUrl()).into(holder.tableImage);
    }


    @Override
    public int getItemCount() {
        return mesas.size();
    }

    void updateItems(List<Mesa> mesas) {
        this.mesas.clear();
        this.mesas.addAll(mesas);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMesaId, txtNombreMesa;
        private ImageView tableImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMesaId = itemView.findViewById(R.id.txtMesaId);
            txtNombreMesa = itemView.findViewById(R.id.txtNombreMesa);
            tableImage = itemView.findViewById(R.id.tableImage);


        }

        void bind(Mesa mesa, int position) {
            txtMesaId.setText(String.valueOf(mesa.getId()));
            txtNombreMesa.setText(mesa.getNombre());
//            Picasso.get().load(mesas.get(position).getImagenUrl());
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(mesa, position));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Mesa mesa, int position);
    }
}
