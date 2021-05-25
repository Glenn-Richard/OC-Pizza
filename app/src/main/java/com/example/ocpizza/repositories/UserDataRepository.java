package com.example.ocpizza.repositories;

import androidx.lifecycle.LiveData;

import com.example.ocpizza.database.UserDao;
import com.example.ocpizza.model.User;

import java.util.List;

public class UserDataRepository {

    private UserDao userDao;

    public UserDataRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    //GETTERS

    public LiveData<List<User>> getUsers(){
        return userDao.getUsers();
    }

    public LiveData<User> getUser(User user){
        return userDao.findUser(user.getEmail(),user.getPassword());
    }

    //INSERT

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    //DELETE

    public void deleteUser(User user){
        userDao.deleteUser(user);
    }
}
