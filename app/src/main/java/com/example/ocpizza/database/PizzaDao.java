package com.example.ocpizza.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ocpizza.model.Pizza;

import java.util.List;

@Dao
public interface PizzaDao {
    @Insert
    void insertPizza(Pizza pizza);

    @Insert
    void insertPizzas(List<Pizza> pizzas);
    @Delete
    void deletePizza(Pizza pizza);

    @Query("SELECT * FROM Pizza")
    LiveData<List<Pizza>> getPizzas();
}
