package com.example.meserosapp.ui.tipoproducto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.TipoProducto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TipoProductoRecyclerAdapter extends RecyclerView.Adapter<TipoProductoRecyclerAdapter.ViewHolder>
{

    private List<TipoProducto> categorias = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;

    TipoProductoRecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_categorylist_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(categorias.get(position), position);
        Picasso.get().load(categorias.get(position).getImagenUrl()).into(holder.categoryImage);

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    void updateItems(List<TipoProducto> categorias) {
        this.categorias.clear();
        this.categorias.addAll(categorias);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCategoriaId, txtNombreCategoria;
        private ImageView categoryImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCategoriaId = itemView.findViewById(R.id.txtCategoriaId);
            txtNombreCategoria = itemView.findViewById(R.id.txtNombreCategoria);
            categoryImage = itemView.findViewById(R.id.categoryImage);

        }

        void bind(TipoProducto tipoProducto, int position) {
            txtCategoriaId.setText(String.valueOf(tipoProducto.getId()));
            txtNombreCategoria.setText(tipoProducto.getDescripcion());
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(tipoProducto, position));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(TipoProducto tipoProducto, int position);
    }


}
