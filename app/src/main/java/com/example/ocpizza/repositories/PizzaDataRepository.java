package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.PizzaDao;
import com.example.ocpizza.model.Pizza;
import com.example.ocpizza.model.Pizzeria;

import java.util.List;

public class PizzaDataRepository {

    private PizzaDao pizzaDao;

    public PizzaDataRepository(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    //GETTER

    public LiveData<List<Pizza>> getPizzas(){
        return pizzaDao.getPizzas();
    }

    //INSERT

    public void insertPizza(Pizza pizza){
        pizzaDao.insertPizza(pizza);
    }

    //DELETE

    public void deletePizza(Pizza pizza){
        pizzaDao.deletePizza(pizza);
    }
}
