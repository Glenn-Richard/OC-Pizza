package com.example.ocpizza.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Function")
public class Function {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    @Nullable
    private Pizzeria pizzeria;

    private String password;


    public Function(int id, String name, @Nullable Pizzeria pizzeria, String password) {
        this.id = id;
        this.name = name;
        this.pizzeria = pizzeria;
        this.password = password;
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

    @Nullable
    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(@Nullable Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
