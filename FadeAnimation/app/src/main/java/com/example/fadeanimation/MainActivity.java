package com.example.fadeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivAndroid11, ivAndroid12;
    boolean isAndroid11Showing = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAndroid11 = findViewById(R.id.ivAndroid11);
        ivAndroid12 = findViewById(R.id.ivAndroid12);

    }

    public void fade(View view){
        ivAndroid11 = findViewById(R.id.ivAndroid11);
        ivAndroid12 = findViewById(R.id.ivAndroid12);

        if (isAndroid11Showing){
            isAndroid11Showing = false;
            ivAndroid11.animate().alpha(0).setDuration(2000);
            ivAndroid12.animate().alpha(1).setDuration(2000);
        }
        else{
            isAndroid11Showing = true;
            ivAndroid11.animate().alpha(1).setDuration(2000);
            ivAndroid12.animate().alpha(0).setDuration(2000);

        }
    }
}