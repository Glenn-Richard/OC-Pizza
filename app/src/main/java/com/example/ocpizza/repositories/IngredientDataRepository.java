package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.IngredientDao;
import com.example.ocpizza.model.Ingredient;

import java.util.List;

public class IngredientDataRepository {

    private IngredientDao ingredientDao;

    public IngredientDataRepository(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    //GETTER

    public LiveData<List<Ingredient>> getIngredients(){
        return ingredientDao.getIngredients();
    }

    //INSERT

    public void insertIngredient(Ingredient ingredient){
        ingredientDao.insertIngredient(ingredient);
    }

    //DELETE

    public void deleteIngredient(Ingredient ingredient){
        ingredientDao.deleteIngredient(ingredient);
    }
}
