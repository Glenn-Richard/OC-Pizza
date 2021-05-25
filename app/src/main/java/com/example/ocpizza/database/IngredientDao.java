package com.example.ocpizza.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.ocpizza.model.Ingredient;

import java.util.List;

@Dao
public interface IngredientDao {
    @Insert
    void insertIngredient(Ingredient ingredient);

    @Insert
    void insertIngredients(List<Ingredient> ingredients);

    @Delete
    void deleteIngredient(Ingredient ingredient);

    @Query("SELECT * FROM Ingredient")
    LiveData<List<Ingredient>> getIngredients();
}
