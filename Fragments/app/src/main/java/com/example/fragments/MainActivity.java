package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        description = getResources().getStringArray(R.array.descriptions);

        //  When phone is in portrait mode
        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().
                    hide(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView2))).
                    show(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView))).commit();
        }

        //  When phone is in land mode
        if (findViewById(R.id.layout_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().
                    show(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView))).
                    show(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView2))).commit();
        }
    }

    @Override
    public void onItemSelected(int index) {

        tvDescription.setText(description[index]);

        //  When phone is in portrait mode
        if (findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().
                    show(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView2))).
                    hide(Objects.requireNonNull(manager.findFragmentById(R.id.fragmentContainerView))).
                    addToBackStack(null).
                    commit();
        }
    }
}