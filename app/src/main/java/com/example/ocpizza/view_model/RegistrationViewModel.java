package com.example.ocpizza.view_model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ocpizza.database.DatabaseManager;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.User;
import com.example.ocpizza.repositories.FunctionDataRepository;
import com.example.ocpizza.repositories.UserDataRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RegistrationViewModel extends ViewModel {

    private DatabaseManager database;

    private UserDataRepository userDataRepository;
    private FunctionDataRepository functionDataRepository;

    private Executor executor;

    public RegistrationViewModel(Context context) {
        this.database = DatabaseManager.getDatabase(context);
        this.userDataRepository = new UserDataRepository(database.userDao());
        this.functionDataRepository = new FunctionDataRepository(database.functionDao());
        this.executor = Executors.newSingleThreadExecutor();
    }

    //GETTERS

    public LiveData<User> getUser(User user){
        return userDataRepository.getUser(user);
    }

    public LiveData<List<Function>> getFunctions(){
        return functionDataRepository.getFunctions();
    }

    //INSERT

    public void insertUser(User user){
        executor.execute(() ->
                userDataRepository.insertUser(user));
    }

    //CONFLICT

    public boolean isConflict(User user){
        User test = userDataRepository.getUser(user).getValue();
        if (test!=null){
            return true;
        }
        return false;
    }
}
