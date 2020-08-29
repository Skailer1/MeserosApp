package com.example.meserosapp.ui.producto;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomProductParacelable implements Parcelable {

    private String nombreProducto;
    private Long productoId;

    public CustomProductParacelable(String nombreProducto, Long productoId) {
        this.nombreProducto = nombreProducto;
        this.productoId = productoId;
    }

    protected CustomProductParacelable(Parcel in) {
        productoId = in.readLong();
        nombreProducto = in.readString();

    }

    public static final Creator<CustomProductParacelable> CREATOR = new Creator<CustomProductParacelable>() {
        @Override
        public CustomProductParacelable createFromParcel(Parcel in) {
            return new CustomProductParacelable(in);
        }

        @Override
        public CustomProductParacelable[] newArray(int size) {
            return new CustomProductParacelable[size];
        }
    };

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Long getProductoId() {
        return productoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(productoId);
        dest.writeString(nombreProducto);

    }
}
