package com.example.ocpizza.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Pizza",
        foreignKeys = @ForeignKey(
        entity = Pizzeria.class,
        parentColumns = "id",
        childColumns = "id"))
public class Pizza {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private double price;

    private List<Ingredient> composition;

    private boolean available;

    public Pizza(String name, double price, List<Ingredient> composition, boolean available) {
        this.name = name;
        this.price = price;
        this.composition = composition;
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

    public List<Ingredient> getComposition() {
        return composition;
    }

    public void setComposition(List<Ingredient> composition) {
        this.composition = composition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
