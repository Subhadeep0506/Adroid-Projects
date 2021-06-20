package com.example.explicitintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Application2 extends AppCompatActivity {

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application2);

        textResult = findViewById(R.id.resultText);

        String name = getIntent().getStringExtra("name");
        /* getIntExtra(name, defaultValue)
         * here, we must give a default value to return
         * this is because, if the name is not present in the activity from where name is passed,
         * int cannot return null, whereas String can. Thus a default value must be specified
         */

        String output = name + ", Welcome to Activity 2!";
        textResult.setText(output);
    }
}