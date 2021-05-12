package com.example.ocpizza.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Pizzeria")
public class Pizzeria {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String location;

    private List<Pizza> available;

    public Pizzeria( String name, String location, List<Pizza> available) {
        this.name = name;
        this.location = location;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Pizza> getAvailable() {
        return available;
    }

    public void setAvailable(List<Pizza> available) {
        this.available = available;
    }
}
