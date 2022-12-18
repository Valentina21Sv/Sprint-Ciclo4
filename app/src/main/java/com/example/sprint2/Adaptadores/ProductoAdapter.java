package com.example.sprint2.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprint2.Entidades.Producto;
import com.example.sprint2.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList <Producto> arrayProductos;

    public ProductoAdapter(Context context, ArrayList<Producto> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;
    }

    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.producto_template, null);

        Producto producto = arrayProductos.get(i);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView textNameProduct = (TextView) view.findViewById(R.id.textNameProduct);
        TextView textDescriptionProduct = (TextView) view.findViewById(R.id.textDescriptionProduct);
        TextView textPriceProduct = (TextView) view.findViewById(R.id.textPriceProduct);

        imgProduct.setImageResource(producto.getImage());
        textNameProduct.setText(producto.getName());
        textDescriptionProduct.setText(producto.getDescription());
        textPriceProduct.setText(String.valueOf(producto.getPrice()));

        return view;
    }
}
