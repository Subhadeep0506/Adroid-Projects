package com.example.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this); // Vertical list
        //  Horizontal Scrolling list
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //  To make a grid view of list
        //layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<>();

        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Han", "Solo", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Michael", "Jordan", "bus"));
        people.add(new Person("Smith", "Sam", "plane"));
        people.add(new Person("Michael", "Jordan", "bus"));
        people.add(new Person("Smith", "Sam", "plane"));
        people.add(new Person("Smith", "Sam", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Han", "Solo", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Han", "Solo", "plane"));
        people.add(new Person("Michael", "Jordan", "bus"));
        people.add(new Person("Smith", "Sam", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Han", "Solo", "plane"));
        people.add(new Person("Michael", "Jordan", "bus"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}