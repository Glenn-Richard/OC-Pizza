package com.example.ocpizza.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ocpizza.model.Order;

@Dao
public interface OrderDao {
    @Insert
    void insertOrder(Order order);

    @Delete
    void deleteOrder(Order order);

    @Query("SELECT * FROM Order WHERE userId LIKE :userId")
    LiveData<Integer> getOrders(int userId);
}
