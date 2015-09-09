package com.lvc.cars.model;

/**
 * Created by administrator on 7/27/15.
 */
public class Car {

    private int id;
    private int type;
    private String title;
    private String description;

    public Car() {
    }

    public Car(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return title + " " + description;
    }
}
