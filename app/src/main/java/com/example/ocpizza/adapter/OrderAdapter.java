package com.example.ocpizza.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ocpizza.R;
import com.example.ocpizza.model.Ingredient;
import com.example.ocpizza.model.Pizza;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Pizza> pizzas;

    public OrderAdapter(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void updatePizza(List<Pizza> pizzas){
        this.pizzas = pizzas;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        holder.display(pizzas.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView image;
        private final TextView title;
        private final TextView ingredient;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.pizza_picture);
            title = itemView.findViewById(R.id.pizza_name);
            ingredient = itemView.findViewById(R.id.text_ingredient);
            price = itemView.findViewById(R.id.pizza_price);
        }
        @SuppressLint("SetTextI18n")
        public void display(Pizza pizza){
            Glide.with(itemView.getContext())
                    .load(pizza.getPicture())
                    .apply(RequestOptions.circleCropTransform())
                    .into(image);
            title.setText(pizza.getName());
            String list_ingredient = "";
            for (Ingredient ingredient : pizza.getComposition()){
                list_ingredient = list_ingredient+ingredient.getName();
            }
            ingredient.setText(list_ingredient);
            price.setText(String.valueOf(pizza.getPrice()));
        }
    }
}
