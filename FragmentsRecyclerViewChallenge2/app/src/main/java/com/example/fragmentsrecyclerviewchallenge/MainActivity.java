package com.example.fragmentsrecyclerviewchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCar, btnOwner;
    TextView tvModel, tvNumber, tvOwner;
    ImageView ivCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);
        tvModel = findViewById(R.id.tvModel);
        tvNumber = findViewById(R.id.tvNumber);
        tvOwner = findViewById(R.id.tvOwner);
        ivCar = findViewById(R.id.ivCar);

        btnCar.setOnClickListener(v -> {

        });

        btnOwner.setOnClickListener(v -> {

        });
    }
}