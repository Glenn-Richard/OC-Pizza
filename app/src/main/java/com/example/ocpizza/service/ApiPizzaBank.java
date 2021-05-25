package com.example.ocpizza.service;

import com.example.ocpizza.R;
import com.example.ocpizza.model.Function;
import com.example.ocpizza.model.Ingredient;
import com.example.ocpizza.model.Pizza;
import com.example.ocpizza.model.Pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiPizzaBank {

    /*
    * Compositions des différentes pizzas avec la fonction composition
    * */

    List<Ingredient> MARGHERITA = composition(choice_pizza.MARGHERITA);
    List<Ingredient> REGINA = composition(choice_pizza.REGINA);
    List<Ingredient> EXTRA_VIANDE = composition(choice_pizza.EXTRA_VIANDE);
    List<Ingredient> FORESTIERE = composition(choice_pizza.FORESTIERE);
    List<Ingredient> CHEVRE_MIEL = composition(choice_pizza.CHEVRE_MIEL);
    List<Ingredient> PEPERONI = composition(choice_pizza.PEPERONI);
    List<Ingredient> ORIENTALE = composition(choice_pizza.ORIENTALE);

    public List<Ingredient> INGREDIENTS = Arrays.asList(
            new Ingredient("Sauce tomate",1,true),
            new Ingredient("Crème fraiche",1,true),
            new Ingredient("Fromage",1,true),
            new Ingredient("Jambon",1,true),
            new Ingredient("Lardon",1,true),
            new Ingredient("Oignon",1,true),
            new Ingredient("Peperoni",1,true),
            new Ingredient("Poivron",1,true),
            new Ingredient("Chèvre",1,true),
            new Ingredient("Miel",1,true)
    );
    public List<Pizza> PIZZAS = Arrays.asList(
            new Pizza("Margherita", R.mipmap.oc_pizza_picture, 9.5, MARGHERITA,true),
            new Pizza("Regina", R.mipmap.oc_pizza_picture, 12.5, REGINA,true),
            new Pizza("Extra Viande", R.mipmap.oc_pizza_picture, 14.0, EXTRA_VIANDE,true),
            new Pizza("Forestière", R.mipmap.oc_pizza_picture, 11.5, FORESTIERE,true),
            new Pizza("Chèvre Miel", R.mipmap.oc_pizza_picture, 13.5, CHEVRE_MIEL,true),
            new Pizza("Peperoni", R.mipmap.oc_pizza_picture, 13.0, PEPERONI,true),
            new Pizza("Orientale", R.mipmap.oc_pizza_picture, 13.5, ORIENTALE,true)
    );
    public List<Pizzeria> PIZZERIAS = Arrays.asList(
            new Pizzeria("OC Pizza Paris","Paris",PIZZAS),
            new Pizzeria("OC Pizza Lyon","Lyon",PIZZAS),
            new Pizzeria("OC Pizza Marseille","Marseille",PIZZAS),
            new Pizzeria("OC Pizza Lille","Lille",PIZZAS),
            new Pizzeria("OC Pizza Bordeaux","Bordeaux",PIZZAS),
            new Pizzeria("OC Pizza Toulouse","Toulouse",PIZZAS),
            new Pizzeria("OC Pizza Montpellier","Montpellier",PIZZAS),
            new Pizzeria("OC Pizza Nice","Nice",PIZZAS)
    );
    public List<Function> FUNCTIONS = Arrays.asList(
            new Function(00,"Client",null,null),
            new Function(01,"Pizzaiolo",null,"pizzaiolo12345"),
            new Function(02,"Manager",null,"manager12345"),
            new Function(03,"Coursier",null,"coursier12345")
    );
    public List<Ingredient> composition(choice_pizza choice){

        List<Ingredient> pizza = new ArrayList<>();
        switch (choice){
            case MARGHERITA:
                INGREDIENTS.get(2).setQuantity(2);
                MARGHERITA.add(INGREDIENTS.get(0));
                MARGHERITA.add(INGREDIENTS.get(2));
                pizza.addAll(MARGHERITA);
                break;

            case REGINA:
                REGINA.add(INGREDIENTS.get(0));
                REGINA.add(INGREDIENTS.get(2));
                REGINA.add(INGREDIENTS.get(3));
                pizza.addAll(REGINA);
                break;

            case EXTRA_VIANDE:
                EXTRA_VIANDE.add(INGREDIENTS.get(0));
                EXTRA_VIANDE.add(INGREDIENTS.get(2));
                EXTRA_VIANDE.add(INGREDIENTS.get(3));
                EXTRA_VIANDE.add(INGREDIENTS.get(4));
                pizza.addAll(EXTRA_VIANDE);
                break;

            case PEPERONI:
                PEPERONI.add(INGREDIENTS.get(0));
                PEPERONI.add(INGREDIENTS.get(2));
                INGREDIENTS.get(6).setQuantity(2);
                PEPERONI.add(INGREDIENTS.get(6));
                pizza.addAll(PEPERONI);
                break;

            case ORIENTALE:
                ORIENTALE.add(INGREDIENTS.get(0));
                ORIENTALE.add(INGREDIENTS.get(2));
                ORIENTALE.add(INGREDIENTS.get(5));
                ORIENTALE.add(INGREDIENTS.get(6));
                ORIENTALE.add(INGREDIENTS.get(7));
                ORIENTALE.add(INGREDIENTS.get(8));
                pizza.addAll(ORIENTALE);
                break;

            case FORESTIERE:
                FORESTIERE.add(INGREDIENTS.get(1));
                FORESTIERE.add(INGREDIENTS.get(2));
                FORESTIERE.add(INGREDIENTS.get(5));
                FORESTIERE.add(INGREDIENTS.get(6));
                pizza.addAll(FORESTIERE);
                break;

            case CHEVRE_MIEL:
                CHEVRE_MIEL.add(INGREDIENTS.get(1));
                CHEVRE_MIEL.add(INGREDIENTS.get(8));
                INGREDIENTS.get(9).setQuantity(2);
                CHEVRE_MIEL.add(INGREDIENTS.get(9));
                pizza.addAll(CHEVRE_MIEL);
        }
        resetQuantity();
        return pizza;
    }
    public void resetQuantity(){
        for (int i=0;i<INGREDIENTS.size();i++){
            INGREDIENTS.get(i).setQuantity(1);
        }
    }
    public enum choice_pizza{

        MARGHERITA,

        REGINA,

        EXTRA_VIANDE,

        FORESTIERE,

        CHEVRE_MIEL,

        PEPERONI,

        ORIENTALE

    }
}
