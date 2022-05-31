package com.example.carlist.models;

public class Car {
    int image;

    String name, brand;

    public Car(int image, String name, String brand) {
        this.image = image;
        this.name = name;
        this.brand = brand;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
