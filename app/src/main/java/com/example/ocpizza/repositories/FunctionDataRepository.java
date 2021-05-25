package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.FunctionDao;
import com.example.ocpizza.model.Function;

import java.util.List;

public class FunctionDataRepository {

    private FunctionDao functionDao;

    public FunctionDataRepository(FunctionDao functionDao) {
        this.functionDao = functionDao;
    }

    //GETTER

    public LiveData<List<Function>> getFunctions(){
        return functionDao.getFunctions();
    }
}
