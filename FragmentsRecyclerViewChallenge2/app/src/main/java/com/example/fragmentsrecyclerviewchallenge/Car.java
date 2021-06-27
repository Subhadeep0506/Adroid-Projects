package com.example.fragmentsrecyclerviewchallenge;

public class Car {

    private String model, make, ownerNAme, ownerNumber;

    public Car(String model, String make, String ownerNAme, String ownerNumber) {
        this.model = model;
        this.make = make;
        this.ownerNAme = ownerNAme;
        this.ownerNumber = ownerNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getOwnerNAme() {
        return ownerNAme;
    }

    public void setOwnerNAme(String ownerNAme) {
        this.ownerNAme = ownerNAme;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }
}
