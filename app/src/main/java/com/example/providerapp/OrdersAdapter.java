package com.example.providerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.providerapp.Models.ProviderData;
import com.example.providerapp.databinding.OrdersCardBinding;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {
    ArrayList<> data;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrdersCardBinding binding = OrdersCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder binding, int position) {
        int pos = position;
        //TODO set data

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView customerName, orderDate, orderID, orderLocation;
        ImageView orderImg;
        Button orderDetailsBtn;

        public MyViewHolder(@NonNull OrdersCardBinding binding) {
            super(binding.getRoot());
            customerName = binding.customerName;
            orderDate = binding.orderDate;
            orderID = binding.orderID;
            orderImg = binding.orderImg;
            orderDetailsBtn = binding.orderDetailsBtn;
            orderLocation = binding.orderLocation;

        }
    }
}
