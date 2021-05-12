package com.example.ocpizza.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void insertOrder(OrderDao order);

    @Delete
    void deleteOrder(OrderDao order);

    @Query("SELECT * FROM Order")
    List<OrderDao> getOrders();
}
