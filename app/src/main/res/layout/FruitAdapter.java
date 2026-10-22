package com.example.tp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FruitAdapter
        extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private final String[] fruits = {
            "Pomme",
            "Banane",
            "Orange",
            "Fraise",
            "Mangue",
            "Raisin",
            "Ananas",
            "Pastèque"
    };

    private final String[] descriptions = {
            "La pomme est un fruit riche en fibres.",
            "La banane est riche en potassium.",
            "L'orange est riche en vitamine C.",
            "La fraise est un fruit rouge et sucré.",
            "La mangue est un fruit tropical.",
            "Le raisin pousse en grappes.",
            "L'ananas est un fruit tropical juteux.",
            "La pastèque est un fruit riche en eau."
    };

    public static class FruitViewHolder
            extends RecyclerView.ViewHolder {

        TextView textFruit;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            textFruit = itemView.findViewById(R.id.textFruit);
        }
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fruit, parent, false);

        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull FruitViewHolder holder,
            int position) {

        holder.textFruit.setText(fruits[position]);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(
                    v.getContext(),
                    fruits[position] + " : " + descriptions[position],
                    Toast.LENGTH_LONG
            ).show();
        });
    }

    @Override
    public int getItemCount() {
        return fruits.length;
    }
}
