package com.example.ocpizza.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ocpizza.model.Function;

import java.util.List;

@Dao
public interface FunctionDao {
    @Insert
    void insertFunction(Function function);

    @Delete
    void deleteFunction(Function function);

    @Query("SELECT * FROM Function")
    List<Function> getFunctions();
}
