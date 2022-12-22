package com.example.sprint2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprint2.DB.DBfirebase;
import com.example.sprint2.DB.DBhelper;
import com.example.sprint2.Entidades.Producto;

public class AgregarProducto extends AppCompatActivity {
    private Button btnForm;
    private EditText editName, editDescription, editPrice, editCategoria;
    private DBfirebase dBfirebase;
    private DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrergar_producto);

        btnForm = findViewById(R.id.btnAddProducto);
        editName = findViewById(R.id.insProducto);
        editDescription = findViewById(R.id.insDescripcion);
        editPrice = findViewById(R.id.insPrecio);
        editCategoria = findViewById(R.id.insCategoria);

        dBfirebase = new DBfirebase();
        dBhelper = new DBhelper(this);

        btnForm.setOnClickListener(view -> {
            Producto producto = new Producto(
                    editName.getText().toString(),
                    editDescription.getText().toString(),
                    editCategoria.getText().toString(),
                    Integer.parseInt(editPrice.getText().toString()),
                    ""
            );
            dBfirebase.insertData(producto);
            dBhelper.insertarDatos(producto);
            Intent intent  = new Intent(getApplicationContext(), Productos.class);
            startActivity(intent);
        });




    }

}