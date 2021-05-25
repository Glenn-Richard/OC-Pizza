package com.example.ocpizza.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.ocpizza.converter.Converters;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.Ingredient;
import com.example.ocpizza.model.Order;
import com.example.ocpizza.model.Pizza;
import com.example.ocpizza.model.Pizzeria;
import com.example.ocpizza.model.User;
import com.example.ocpizza.service.ApiPizzaBank;

@Database(entities = {
        User.class, Pizzeria.class, Pizza.class, Order.class, Ingredient.class, Function.class},
        version = 1,exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabaseManager extends RoomDatabase {

    private static volatile DatabaseManager INSTANCE;

    public abstract UserDao userDao();
    public abstract PizzeriaDao pizzeriaDao();
    public abstract PizzaDao pizzaDao();
    public abstract OrderDao orderDao();
    public abstract IngredientDao ingredientDao();
    public abstract FunctionDao functionDao();

    public static DatabaseManager getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseManager.class, "oc_pizza_database")
                            .build();
                    INSTANCE.functionDao().insertFunctions(new ApiPizzaBank().FUNCTIONS);
                    INSTANCE.ingredientDao().insertIngredients(new ApiPizzaBank().INGREDIENTS);
                    INSTANCE.pizzaDao().insertPizzas(new ApiPizzaBank().PIZZAS);
                    INSTANCE.pizzeriaDao().insertPizzerias(new ApiPizzaBank().PIZZERIAS);
                }
            }
        }
        return INSTANCE;
    }
}
