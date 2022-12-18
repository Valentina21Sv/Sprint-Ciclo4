package com.example.sprint2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.sprint2.Adaptadores.ProductoAdapter;
import com.example.sprint2.Entidades.Producto;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {
    private ListView listViewProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

       listViewProductos = (ListView) findViewById(R.id.listViewProductos);
       arrayProductos = new ArrayList<>();

        Producto producto1 = new Producto("Producto1", "Descripcion1", 1000,R.drawable.dino);
        Producto producto2 = new Producto("Producto2", "Descripcion2", 2000,R.drawable.monster);
        Producto producto3 = new Producto("Producto3", "Descripcion3", 3000,R.drawable.mushrooms);
        Producto producto4 = new Producto("Producto4", "Descripcion4", 4000,R.drawable.dino);
        Producto producto5 = new Producto("Producto5", "Descripcion5", 5000,R.drawable.monster);
        Producto producto6 = new Producto("Producto6", "Descripcion6", 6000,R.drawable.mushrooms);


       productoAdapter = new ProductoAdapter(this,arrayProductos);
       listViewProductos.setAdapter(productoAdapter);
    }
}