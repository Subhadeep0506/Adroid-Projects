package com.example.vectorasset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button btnChange;
    ImageButton imageButton1, imageButton2, imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        btnChange = findViewById(R.id.btnChange);
        imageButton1 = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);

        btnChange.setOnClickListener(v ->{

            image.setImageResource(R.drawable.brightness_2);

        });

        imageButton1.setOnClickListener(v -> {
            image.setImageResource(R.drawable.brightness_1);
        });

        imageButton2.setOnClickListener(v -> {
            image.setImageResource(R.drawable.brightness_2);
        });

        imageButton3.setOnClickListener(v -> {
            image.setImageResource(R.drawable.brightness_3);
        });
    }
}