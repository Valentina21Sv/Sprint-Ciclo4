package com.example.sprint2.DB;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import com.example.sprint2.Entidades.Producto;
import com.example.sprint2.Service.ProductoService;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBfirebase {
    private final FirebaseFirestore TiendaDB;
    public ProductoService productoService;

    public DBfirebase() {
        this.TiendaDB = FirebaseFirestore.getInstance();
        this.productoService = new ProductoService();

    }

    public void insertData(Producto producto) {
        // Creamos la tabla Productos
        Map<String, Object> productos = new HashMap<>();
        productos.put("id", producto.getId());
        productos.put("name", producto.getName());
        productos.put("description", producto.getDescription());
        productos.put("price", producto.getPrice());
        productos.put("image", producto.getImage());
        productos.put("f_eliminar", producto.isEliminate());
        productos.put("f_actualizado", producto.getActualization());
        productos.put("f_creado", producto.getCreate());
        TiendaDB.collection("PRODUCTOS").add(productos);
    }

    public void getData(ArrayList<Producto> list) {
        TiendaDB.collection("PRODUCTOS")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Producto producto;
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            producto = new Producto(
                                    document.getData().get("id").toString(),
                                    (document.getData().get("NOMBRE")).toString(),
                                    (document.getData().get("DESCRIPCION")).toString(),
                                    document.getData().get("CATEGORIA").toString(),
                                    Integer.parseInt((document.getData().get("PRECIO")).toString()),
                                    document.getData().get("IMAGEN").toString(),
                                    Boolean.valueOf(document.getData().get("F_ELIMINADO").toString()),
                                    productoService.formatoFecha(document.getData().get("F_CREADO").toString()),
                                    productoService.formatoFecha(document.getData().get("F_ACTUALIZADO").toString())
                            );
                            list.add(producto);
                        }
                        //adapter.setArrayProductos(list);
                        //adapter.notifyDataSetChanged();
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

    public void deleteData(String id) {
        TiendaDB.collection("PRODUCTOS").document(id).delete().addOnSuccessListener(avoid -> Log.d(TAG, "DocumentSnapshot successfully deleted!"))
                .addOnFailureListener(e -> Log.w(TAG, "Error deleting document", e));
    }
}