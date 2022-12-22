package com.example.sprint2.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.sprint2.Entidades.Producto;

import com.example.sprint2.Service.ProductoService;

public class DBhelper extends SQLiteOpenHelper {
    private SQLiteDatabase TiendaDB;
    private ProductoService productoService;

    public DBhelper (Context context){
        super(context, "TiendaDB.db", null, 1);
        TiendaDB = this.getWritableDatabase();
        this.productoService = new ProductoService();
    }

    @Override
    public void onCreate(SQLiteDatabase TiendaDB) {

        TiendaDB.execSQL("CREATE TABLE PRODUCTOS(" +
                "id VARCHAR PRIMARY KEY," +
                "NOMBRE VARCHAR," +
                "DESCRIPCION VARCHAR," +
                "PRECIO INTEGER," +
                "IMAGEN VARCHAR," +
                "F_ELIMINAR BOOLEAN," +
                "F_CREACION TEXT," +
                "F_ACTUALIZADO TEXT," +
                "CATEGORIA VARCHAR" +
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
    }

    public void insertarDatos(Producto producto) {

        String sql = "INSERT INTO PRODUCTOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = TiendaDB.compileStatement(sql);

        statement.bindString(1, producto.getId());
        statement.bindString(2, producto.getName());
        statement.bindString(3, producto.getDescription());
        statement.bindLong(4, producto.getPrice());
        statement.bindString(5, producto.getImage());
        statement.bindString(6, String.valueOf(producto.isEliminate()));
        statement.bindString(7, String.valueOf(producto.getCreate()));
        statement.bindString(8, String.valueOf(producto.getActualization()));
        statement.bindString(9, producto.getCategory());

        statement.executeInsert();
        //statement.close();

    }

    public Cursor consultarDatos() {
        return TiendaDB.rawQuery("SELECT * FROM PRODUCTOS", null);
    }
}

