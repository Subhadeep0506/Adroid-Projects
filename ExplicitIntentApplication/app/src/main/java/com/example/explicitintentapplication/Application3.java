package com.example.explicitintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Application3 extends AppCompatActivity {

    EditText inputTextApp3;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application3);

        inputTextApp3 = findViewById(R.id.inputTextApp3);
        btnSubmit = findViewById(R.id.btnSubmit);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(v -> {

            if(inputTextApp3.getText().toString().isEmpty()){
                Toast.makeText(Application3.this, "please enter all fields", Toast.LENGTH_SHORT).show();
            }
            else{
                String surname = inputTextApp3.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("surname", surname);
                setResult(RESULT_OK, intent);
                Application3.this.finish();
            }
        });

        btnCancel.setOnClickListener(v -> {

            setResult(RESULT_CANCELED);
            Application3.this.finish();
        });

    }
}