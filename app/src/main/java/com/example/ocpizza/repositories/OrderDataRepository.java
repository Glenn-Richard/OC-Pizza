package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.OrderDao;
import com.example.ocpizza.model.Order;

import java.util.List;

public class OrderDataRepository {

    private OrderDao orderDao;

    public OrderDataRepository(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //GETTER

    public LiveData<Integer> getOrder(int userId){
        return orderDao.getOrders(userId);
    }

    //INSERT

    public void insertOrder(Order order){
        orderDao.insertOrder(order);
    }

    //DELETE

    public void deleteOrder(Order order){
        orderDao.deleteOrder(order);
    }
}
