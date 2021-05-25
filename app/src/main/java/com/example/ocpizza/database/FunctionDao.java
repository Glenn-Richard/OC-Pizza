package com.example.ocpizza.database;

import androidx.lifecycle.LiveData;
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

    @Insert
    void  insertFunctions(List<Function> functions);
    @Delete
    void deleteFunction(Function function);

    @Query("SELECT * FROM Function")
    LiveData<List<Function>> getFunctions();
}
