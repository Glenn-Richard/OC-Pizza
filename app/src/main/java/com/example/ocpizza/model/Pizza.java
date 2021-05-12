package com.example.ocpizza.model;

import android.media.Image;

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

    private int picture;

    private double price;

    private List<Ingredient> composition;

    private boolean available;

    public Pizza(String name, int picture, double price, List<Ingredient> composition, boolean available) {
        this.name = name;
        this.picture = picture;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
