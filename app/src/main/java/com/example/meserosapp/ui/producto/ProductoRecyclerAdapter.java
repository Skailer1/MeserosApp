package com.example.meserosapp.ui.producto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meserosapp.R;
import com.example.meserosapp.data.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoRecyclerAdapter extends RecyclerView.Adapter<ProductoRecyclerAdapter.ViewHolder>
{
    private List<Producto> productos = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;

    ProductoRecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_productlist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(productos.get(position), position);
        Picasso.get().load(productos.get(position).getImagenUrl()).into(holder.productImage);

    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    void updateItems(List<Producto> productos) {
        this.productos.clear();
        this.productos.addAll(productos);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtProductoId, txtNombreProducto, txtCosto, txtCantidadStock;
        private ImageView productImage;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProductoId = itemView.findViewById(R.id.txtProductoId);
            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
            txtCosto = itemView.findViewById(R.id.txtCosto);
            txtCantidadStock = itemView.findViewById(R.id.txtCantidadStock);
            productImage = itemView.findViewById(R.id.productImage);
        }

        void bind(Producto producto, int position) {
            txtProductoId.setText(String.valueOf(producto.getId()));
            txtNombreProducto.setText(producto.getNombreProducto());
            txtCosto.setText(producto.getTipoProducto().getDescripcion());
            txtCantidadStock.setText(String.valueOf(producto.getCantidadEnStock()));
            //  Picasso.get().load(productos.get(position).getImagenUrl());
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(producto, position));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Producto producto, int position);

    }

}
