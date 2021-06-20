package com.example.frangmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

//  An application class runs right at the beginning when the application starts,
//  even before the main activity starts, also gets destroyed at the very end.

//  IMPORTANT: FOR THIS CLASS TO BE RECOGNIZED AS APPLICATION CLASS BY IDE,
//  WE NEED TO ADD android:name=".ApplicationClass" IN THE ANDROID
//  MANIFEST FILE INSIDE ANDROID TAG.###############
public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<>();
        people.add(new Person("Chuck Norris", "9877699772"));
        people.add(new Person("John Rambo", "8643846532"));
        people.add(new Person("Boris Chuck", "7263740263"));
    }
}
