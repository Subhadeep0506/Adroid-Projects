package com.example.explicitintentapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text_1;
    Button btnApp2, btnApp3;
    TextView tvRslt;

    final int ACTIVITY_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_1 = findViewById(R.id.text_1);
        btnApp2 = findViewById(R.id.btnApp2);
        btnApp3 = findViewById(R.id.btnApp3);
        tvRslt = findViewById(R.id.tvRslt);

        btnApp2.setOnClickListener(v -> {

            if (text_1.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
            else{
                String name = text_1.getText().toString().trim();


                Intent intent = new Intent(MainActivity.this,
                        Application2.class);

                /*
                 * putExtra(key, value)
                 * key is the data that we wish to call.
                 * And value is the type of data that we wish to pass.
                 */
                intent.putExtra("name", name); // Here, the name of the data being passed is "name"
                                                     // and data being passed is variable name
                //Starts the intent
                startActivity(intent);
            }

        });

        /*  Here, when button will be pressed, the text
            from activity 3 will be received and displayed in main activity
        */
        btnApp3.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,
                    Application3.class);

            startActivityForResult(intent, ACTIVITY_3);
        });
    }

    //This is an overridden method. To be generated.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_3){

            if(resultCode == RESULT_OK){
                tvRslt.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED){
                tvRslt.setText("No data recieved");
            }
        }
    }
}