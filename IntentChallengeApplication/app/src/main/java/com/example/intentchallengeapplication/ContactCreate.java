package com.example.intentchallengeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ContactCreate extends AppCompatActivity implements View.OnClickListener {

    EditText contact_name, contact_number, contact_website, contact_address;
    ImageView emo_happy, emo_ok, emo_sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_create);

        contact_name = findViewById(R.id.contact_name);
        contact_number = findViewById(R.id.contact_number);
        contact_website = findViewById(R.id.contact_website);
        contact_address = findViewById(R.id.contact_address);

        emo_happy = findViewById(R.id.emo_happy);
        emo_ok = findViewById(R.id.emo_ok);
        emo_sad = findViewById(R.id.emo_sad);

        emo_happy.setOnClickListener(this);
        emo_ok.setOnClickListener(this);
        emo_sad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (contact_name.getText().toString().isEmpty() || contact_number.getText().toString().isEmpty() ||
                contact_address.getText().toString().isEmpty() || contact_website.getText().toString().isEmpty()){

            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent = new Intent();
            intent.putExtra("name", contact_name.getText().toString().trim());
            intent.putExtra("number", contact_number.getText().toString().trim());
            intent.putExtra("website", contact_website.getText().toString().trim());
            intent.putExtra("address", contact_address.getText().toString().trim());

            if (v.getId() == R.id.emo_happy){

                intent.putExtra("mood", "happy");

            }
            else if (v.getId() == R.id.emo_ok){
                intent.putExtra("mood", "ok");
            }
            else if (v.getId() == R.id.emo_sad){
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK, intent);
            ContactCreate.this.finish();
        }

    }
}