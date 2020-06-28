package com.example.meserosapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.meserosapp.data.modelo.Mesa;

import java.util.List;

public class MesaListAdapter extends ArrayAdapter<String>
{
    List<Mesa> mesas;

    public MesaListAdapter (Context context, int resource, List<Mesa> mesas) {
        super(context, resource);
        this.mesas = mesas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Mesa mesa = mesas.get(position);
        return convertView;
    }
}
