/*
 *  This application will act as a
 */

package com.example.falsecallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvOutput);

        if (getIntent().getData() != null){
            textView.setText(getIntent().getData().toString());
        }
        else{
            textView.setText("No data recieved!");
        }
    }
}