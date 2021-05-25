package com.example.ocpizza.view_model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ocpizza.database.DatabaseManager;
import com.example.ocpizza.model.Order;
import com.example.ocpizza.model.Pizza;
import com.example.ocpizza.model.Pizzeria;
import com.example.ocpizza.model.User;
import com.example.ocpizza.repositories.OrderDataRepository;
import com.example.ocpizza.repositories.PizzaDataRepository;
import com.example.ocpizza.repositories.PizzeriaDataRepository;
import com.example.ocpizza.repositories.UserDataRepository;

import java.util.List;

public class OrderViewModel extends ViewModel {

    DatabaseManager database;

    private OrderDataRepository orderDataRepository;
    private PizzaDataRepository pizzaDataRepository;
    private UserDataRepository userDataRepository;
    private PizzeriaDataRepository pizzeriaDataRepository;

    public OrderViewModel(Context context) {
        database = DatabaseManager.getDatabase(context);
        this.orderDataRepository = new OrderDataRepository(database.orderDao());
        this.pizzaDataRepository = new PizzaDataRepository(database.pizzaDao());
        this.userDataRepository = new UserDataRepository(database.userDao());
        this.pizzeriaDataRepository = new PizzeriaDataRepository(database.pizzeriaDao());
    }

    //INIT

    public void init(){

    }

    //GETTERS

    public LiveData<User> getUser(User user){
        return userDataRepository.getUser(user);
    }

    public LiveData<List<Pizza>> getPizzas(){
        return pizzaDataRepository.getPizzas();
    }

    public LiveData<List<Pizzeria>> getPizzerias(){
        return pizzeriaDataRepository.getPizzerias();
    }

    //INSERT

    public void insertOrder(Order order){
        orderDataRepository.insertOrder(order);
    }

    //DELETE

    public void deleteOrder(Order order){
        orderDataRepository.deleteOrder(order);
    }
}
