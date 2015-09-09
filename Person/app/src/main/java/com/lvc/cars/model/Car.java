package com.lvc.cars.model;

/**
 * Created by administrator on 7/27/15.
 */
public class Car {


    private String name;
    private String description;

    public Car() {
    }

    public Car(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }
}
