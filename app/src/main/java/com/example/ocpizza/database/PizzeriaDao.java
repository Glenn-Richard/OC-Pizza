package com.example.ocpizza.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ocpizza.model.Pizzeria;

import java.util.List;

@Dao
public interface PizzeriaDao {
    @Insert
    void insertPizzeria(Pizzeria pizzeria);

    @Insert
    void insertPizzerias(List<Pizzeria> pizzerias);
    @Delete
    void deletePizzeria(Pizzeria pizzeria);

    @Query("SELECT * FROM Pizzeria")
    LiveData<List<Pizzeria>> getPizzerias();

    @Query("SELECT * FROM user WHERE name LIKE :name  LIMIT 1")
    LiveData<List<Pizzeria>> getPizzeria(String name);
}
