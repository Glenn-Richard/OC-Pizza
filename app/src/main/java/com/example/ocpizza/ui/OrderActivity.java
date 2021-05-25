package com.example.ocpizza.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ocpizza.R;
import com.example.ocpizza.adapter.OrderAdapter;
import com.example.ocpizza.model.Order;
import com.example.ocpizza.model.Pizza;
import com.example.ocpizza.model.Pizzeria;
import com.example.ocpizza.service.ApiPizzaBank;
import com.example.ocpizza.view_model.OrderViewModel;
import com.example.ocpizza.view_model.OrderViewModelFactory;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    OrderViewModel viewModel;

    OrderAdapter adapter;

    RecyclerView rv;

    List<Pizza> pizzas;

    List<Pizzeria> pizzerias = new ApiPizzaBank().PIZZERIAS;
    List<String> pizzerias_name;

    Pizzeria pizzeria_chosen;

    Spinner spinner;
    TextView pizzeria_title;
    TextView item_count;
    ImageView shopping_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        spinner = findViewById(R.id.restaurant);
        pizzeria_title = findViewById(R.id.pizzeria_name);
        item_count = findViewById(R.id.item_number);
        shopping_cart = findViewById(R.id.shopping_cart);

        Toolbar toolbar = findViewById(R.id.order_toolbar);

        setSupportActionBar(toolbar);

        setPizzeriasList();

        setSpinnerList();

        setViewModel();

        setRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        for (int i=0;i<pizzerias.size();i++){
            if (item.toString().equals(pizzerias.get(i).getName())){
                pizzeria_title.setText(item.toString());
                pizzeria_chosen = pizzerias.get(i);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void setSpinnerList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,pizzerias_name);

        spinner.setAdapter(adapter);
    }

    private void setPizzeriasList() {
        for (Pizzeria pizzeria : pizzerias){
            pizzerias_name.add(pizzeria.getName());
        }
    }

    private void setViewModel() {
        OrderViewModelFactory orderViewModelFactory = new OrderViewModelFactory(this);
        viewModel = ViewModelProviders.of(this, orderViewModelFactory)
                .get(OrderViewModel.class);
    }

    private void setRecyclerView() {

        pizzas = viewModel.getPizzas().getValue();

        adapter = new OrderAdapter(pizzas);

        rv = findViewById(R.id.list_pizza_rv);

        rv.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
        rv.setAdapter(adapter);
    }
}