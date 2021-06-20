package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btnConvert;
    EditText input_2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextNumber);
        btnConvert = findViewById(R.id.button);
        input_2 = findViewById(R.id.editTextNumberDecimal);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, "WELCOME", Toast.LENGTH_SHORT).show();
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temperature_1, temperature_2;
                String output = "";
                if (input.getText().toString().length() == 0 && input_2.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Enter one field", Toast.LENGTH_SHORT).show();
                }
                else if (input_2.getText().toString().length() == 0){
                    temperature_1 = Double.parseDouble(input.getText().toString().trim());
                    output = "Fahrenheit: " + (((temperature_1) * 9.0 / 5.0) + 32);
                }
                else if (input.getText().toString().length() == 0){
                    temperature_2 = Double.parseDouble(input_2.getText().toString().trim());
                    output = "Celsius: " + ((temperature_2 - 32) * 5.0 / 9.0);
                }
                else{
                    temperature_1 = Double.parseDouble(input.getText().toString().trim());
                    temperature_2 = Double.parseDouble(input_2.getText().toString().trim());
                    output = "Fahrenheit: " + (((temperature_1) * 9.0 / 5.0) + 32) + "\n" +
                             "Celsius: " + ((temperature_2 - 32) * 5.0 / 9.0);
                }
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(output);
            }
        });
    }
}

//output = "Celsius: " + ((temperature_2 - 32) * 5.0 / 9.0);
//output = "Fahrenheit: " + (((temperature_1) * 9.0 / 5.0) + 32);