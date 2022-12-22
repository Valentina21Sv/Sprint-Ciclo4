package com.example.sprint2.Service;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.sprint2.Entidades.Producto;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ProductoService {

    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    public ArrayList<Producto> cursorToArray(Cursor cursor) {
        ArrayList<Producto> list = new ArrayList<>();
        if (cursor.getCount() == 0) {
            return list;
        } else {
            while (cursor.moveToNext()) {
                Producto producto = new Producto(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        Boolean.valueOf(cursor.getString(6)),
                        formatoFecha(cursor.getString(7)),
                        formatoFecha(cursor.getString(8))
                );
                list.add(producto);

            }
        }
        return list;
    }

    public Date formatoFecha(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
