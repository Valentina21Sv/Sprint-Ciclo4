package com.example.sprint2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    private TextView textNameInfo, textDescriptionInfo, textIdInfo, textPriceInfo;
    private ImageView imgInfo;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textNameInfo = findViewById(R.id.textNameInfo);
        textDescriptionInfo = findViewById(R.id.textDescriptionInfo);
        textPriceInfo = findViewById(R.id.textPriceInfo);
        imgInfo = findViewById(R.id.imageInfo);
        btnInfo = findViewById(R.id.btnInfo);

        Intent intentIN = getIntent();
        textNameInfo.setText(intentIN.getStringExtra("name"));
        textDescriptionInfo.setText(intentIN.getStringExtra("description"));
        textPriceInfo.setText(intentIN.getStringExtra("price"));
        imgInfo.setImageResource(intentIN.getIntExtra("image", 0));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Productos.class);
                startActivity(intent);
            }
        });


    }
}