package com.example.providerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.providerapp.Models.OrderData;
import com.example.providerapp.ViewModels.CreateOfferViewModel;
import com.example.providerapp.databinding.ActivityOrderDetailsBinding;

public class OrderDetails extends AppCompatActivity {
ActivityOrderDetailsBinding binding;
int order_ID;
OrderData orderData;
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences("saveToken" , MODE_PRIVATE);

        CreateOfferViewModel viewModel = new CreateOfferViewModel();

        order_ID = Integer.parseInt(getIntent().getExtras().getString("oder_ID"));
        orderData = (OrderData) getIntent().getSerializableExtra("orderData");

        binding.clientName.setText(orderData.getUser().getName());
        binding.date.setText(orderData.getCreatedAt());
        binding.detailsText.setText(orderData.getDetailsAddress());
        binding.location.setText(orderData.getLong()+"/"+orderData.getLat());
        binding.phone.setText(orderData.getUser().getName());

        binding.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean success = viewModel.createOffer(order_ID , preferences.getString("token" , ""));
               if (success){
                   Toast.makeText(OrderDetails.this, "added successfully", Toast.LENGTH_SHORT).show();
                   finish();
               }else {
                   Toast.makeText(OrderDetails.this, "error!", Toast.LENGTH_SHORT).show();
               }

            }
        });

        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}