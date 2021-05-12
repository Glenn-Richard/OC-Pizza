package com.example.ocpizza.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ocpizza.R;
import com.example.ocpizza.adapter.OrderAdapter;
import com.example.ocpizza.database.DatabaseManager;
import com.example.ocpizza.model.Pizza;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    DatabaseManager database = DatabaseManager.getDatabase(this);

    OrderAdapter adapter;

    RecyclerView rv;

    List<Pizza> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.order_toolbar);
        setSupportActionBar(toolbar);


        setRecyclerView();
    }


    private void setRecyclerView() {
        pizzas = database.pizzaDao().getPizzas();

        adapter = new OrderAdapter(pizzas);

        rv = findViewById(R.id.list_pizza_rv);

        rv.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
        rv.setAdapter(adapter);
    }
}