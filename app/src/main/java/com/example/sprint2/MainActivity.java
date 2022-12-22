package com.example.sprint2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sprint2.Adaptadores.ProductoAdapter;
import com.example.sprint2.Entidades.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProductos;
    public Button botonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayProductos = new ArrayList<>();
        productoAdapter = new ProductoAdapter(this, arrayProductos);
        botonHome = findViewById(R.id.btnHome);

        botonHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Productos.class);
            startActivity(intent);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
/*
        String user = txtUsuario.getText().toString();
        if (!user.isEmpty()) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            menu.findItem(R.id.actionAdd).setVisible(true);
            menu.findItem(R.id.exit).setVisible(true);
            menu.findItem(R.id.menuLogin).setVisible(false);
            invalidateOptionsMenu();
        } else {
            getMenuInflater().inflate(R.menu.menu, menu);
        }*/
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuLogin) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.exit) {
            int id = Integer.parseInt(txtIdUser.getText().toString());
            dbHelper.eliminarUsuario(id);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.actionAdd) {
            Intent intent = new Intent(getApplicationContext(), AgregarCategoria.class);
            intent.putExtra("usuario", txtUsuario.getText().toString());
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.geo) {
            Intent intent = new Intent(getApplicationContext(), Maps.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
