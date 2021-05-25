package com.example.ocpizza.converter;

import androidx.room.TypeConverter;

import com.example.ocpizza.model.Function;
import com.google.gson.Gson;

public class Converters {

    //FOR USER CLASS

    @TypeConverter
    public String fromFunctionToGson(Function function){
        return new Gson().toJson(function);
    }

    @TypeConverter
    public Function fromGsonToFunction(String function){
        return new Gson().fromJson(function,Function.class);
    }
}
