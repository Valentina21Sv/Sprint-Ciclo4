package com.example.sprint2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.sprint2.Adaptadores.ProductoAdapter;
import com.example.sprint2.DB.DBfirebase;
import com.example.sprint2.DB.DBhelper;
import com.example.sprint2.Entidades.Producto;
import com.example.sprint2.Service.ProductoService;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {
    private ListView listViewProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProductos;
    private DBhelper dBhelper;
    private ProductoService productoService;
    private DBfirebase dBfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        dBfirebase = new DBfirebase();
        listViewProductos = findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();

        //dBfirebase.getData(productoAdapter);
        try {
            dBhelper = new DBhelper(this);
            productoService = new ProductoService();
            Cursor cursor = dBhelper.consultarDatos();
            arrayProductos = productoService.cursorToArray(cursor);
            productoAdapter = new ProductoAdapter(this,arrayProductos);
            listViewProductos.setAdapter(productoAdapter);
        } catch (Exception e) {
            Log.e("database", e.toString());
        }


    }
}