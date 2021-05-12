package com.example.ocpizza.model;

import androidx.room.Entity;

@Entity(tableName = "Ingredient")
public class Ingredient {

    private String name;

    private int quantity;

    private boolean available;

    public Ingredient(String name, int quantity, boolean available) {
        this.name = name;
        this.quantity = quantity;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
