package com.example.ocpizza.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Order",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId"))
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;

    /* ID de l'utilisateur client*/
    private int userId;

    private List<User> users;

    /* Il s'agit du prix total de la commande*/
    private double price;

    private List<Pizza> pizzas;

    private Pizzeria pizzeria;

    /*
    * Date et heure à laquelle l'utilisateur en l'occurrence le client passe commande
    * */
    private long start_time;

    /*
    * Date et heure à laquelle la commmande est arrivée à destination (adresse du client)
    * ou récupérée en pizzeria
    * */
    private long finish_time;


}
