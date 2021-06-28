package com.example.fragmentsrecyclerviewchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;

    public CarAdapter(Context context, ArrayList<Car> list) {
        this.cars = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivModel;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            ivModel = itemView.findViewById(R.id.ivModel);
            tvModel = itemView.findViewById(R.id.tvModelCardView);
            tvOwner = itemView.findViewById(R.id.tvOwnerCardView);

            itemView.setOnClickListener(v -> {

            });
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull CarAdapter.ViewHolder holder, int position) {
        //holder
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
