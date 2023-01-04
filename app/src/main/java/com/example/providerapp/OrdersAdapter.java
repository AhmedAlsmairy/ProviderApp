package com.example.providerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.providerapp.Models.OrderData;
import com.example.providerapp.Models.ProviderData;
import com.example.providerapp.databinding.OrdersCardBinding;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {
    List<OrderData> data;
    OrderData orderData;
    DetailsClick detailsClick;

    public OrdersAdapter(List<OrderData> data , DetailsClick detailsClick) {
        this.data = data;
        this.detailsClick = detailsClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrdersCardBinding binding = OrdersCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder binding, int position) {
        int pos = position;
        orderData = data.get(pos);

        binding.customerName.setText(orderData.getUser().getName());
        binding.orderDate.setText(orderData.getCreatedAt());
        binding.orderID.setText(String.valueOf(orderData.getId()));
        binding.orderLocation.setText(orderData.getLong()+"/"+orderData.getLat());

        binding.orderDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsClick.details(orderData.getId() , orderData);
            }
        });

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
