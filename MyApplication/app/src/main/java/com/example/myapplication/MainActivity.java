package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText editID;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult.setText(View.GONE);
        editID = findViewById(R.id.editId);
        btnSubmit = findViewById(R.id.button);
        tvResult = findViewById(R.id.textView);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editID.getText().toString().trim();

                String output;
                if(input.length() == 11){
                    String dob = input.substring(0, 6);
                    int genderCode = Integer.parseInt(Character.toString(input.charAt(6)));
                    String gender;
                    if (genderCode < 5)
                        gender = "Female";
                    else
                        gender = "Male";

                    int nationalityCode = Integer.parseInt(Character.toString(input.charAt(10)));
                    String nationality;
                    if (nationalityCode == 0)
                        nationality = "SA Citizenship";
                    else
                        nationality = "Permanent Citizenship";

                    output = "Date of Birth: " + dob + "\n" +
                            "Gender: " + gender + "\n" +
                            "Nationality: " + nationality;

                }
                else{
                    output = "Invalid Code";
                }
                tvResult.setText(View.VISIBLE);
                tvResult.setText(output);
            }
        });
    }
}