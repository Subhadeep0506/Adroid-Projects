package com.example.intentchallengeapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView contact_icon, contact_number, contact_website, contact_location;
    Button btnCreate;
    final int CREATE_CONTACT = 1;
    String name = "", number = "", address = "", website = "", mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_icon = findViewById(R.id.contact_icon);
        contact_number = findViewById(R.id.contact_number);
        contact_website = findViewById(R.id.contact_website);
        contact_location = findViewById(R.id.contact_location);

        btnCreate = findViewById(R.id.btnCreate);

        contact_icon.setVisibility(View.GONE);
        contact_number.setVisibility(View.GONE);
        contact_website.setVisibility(View.GONE);
        contact_location.setVisibility(View.GONE);

        btnCreate.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,
                    com.example.intentchallengeapplication.ContactCreate.class);

            startActivityForResult(intent, CREATE_CONTACT);
        });

        contact_number.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);

        });

        contact_website.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + website));
            startActivity(intent);
        });

        contact_location.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT){

            if (resultCode == RESULT_OK){

                contact_icon.setVisibility(View.VISIBLE);
                contact_number.setVisibility(View.VISIBLE);
                contact_website.setVisibility(View.VISIBLE);
                contact_location.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                website = data.getStringExtra("website");
                address = data.getStringExtra("address");
                mood = data.getStringExtra("mood");

                if (mood.equals("happy")){
                    contact_icon.setImageResource(R.drawable.very_happy);
                }
                else if (mood.equals("ok")){
                    contact_icon.setImageResource(R.drawable.happy);
                }
                else if (mood.equals("sad")){
                    contact_icon.setImageResource(R.drawable.sad);
                }
            }
            else{
                Toast.makeText(this, "No data passed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}