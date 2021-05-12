package com.example.ocpizza.database;

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

    @Delete
    void deletePizzeria(Pizzeria pizzeria);

    @Query("SELECT * FROM Pizzeria")
    List<Pizzeria> getPizzerias();
}
