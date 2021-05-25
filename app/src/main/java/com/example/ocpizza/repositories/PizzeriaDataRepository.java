package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.PizzeriaDao;
import com.example.ocpizza.model.Pizzeria;

import java.util.List;

public class PizzeriaDataRepository {

    private PizzeriaDao pizzeriaDao;

    public PizzeriaDataRepository(PizzeriaDao pizzeriaDao) {
        this.pizzeriaDao = pizzeriaDao;
    }

    //GETTERS

    public LiveData<List<Pizzeria>> getPizzerias(){
        return pizzeriaDao.getPizzerias();
    }


    public LiveData<List<Pizzeria>> getPizzeria(Pizzeria pizzeria){
        return pizzeriaDao.getPizzeria(pizzeria.getName());
    }

    //INSERT

    public void insertPizzeria(Pizzeria pizzeria){
        pizzeriaDao.insertPizzeria(pizzeria);
    }

    //DELETE

    public void deletePizzeria(Pizzeria pizzeria){
        pizzeriaDao.deletePizzeria(pizzeria);
    }
}
