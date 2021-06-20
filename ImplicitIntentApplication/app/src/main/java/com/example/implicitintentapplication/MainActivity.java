package com.example.implicitintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnCallFrnd, btnBrowser, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnCall = findViewById(R.id.btnCallFrnd);
        btnCall = findViewById(R.id.btnBrowser);
        btnCall = findViewById(R.id.btnMap);

        btnCall.setOnClickListener(v -> {

            //  Asks system if there are any application to make dial number
            Intent intent = new Intent(Intent.ACTION_DIAL);
            //  Starts that dialing Application
            startActivity(intent);

        });

        btnCallFrnd.setOnClickListener(v -> {

            //  Uri -> Unified Resource Identifier
            //  Uri.parse() takes an argument. Here a telephone number
            //  The scheme used here is 'tel'
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9030760998"));
            startActivity(intent);

        });

        btnBrowser.setOnClickListener(v -> {

            //  The scheme here is none. But is a webpage link
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"));
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {

            //  The scheme used here is 'geo' for asking map applications
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Gajuwaka"));
            startActivity(intent);

        });

    }
}