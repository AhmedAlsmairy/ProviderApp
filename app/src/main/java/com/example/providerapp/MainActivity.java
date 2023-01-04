package com.example.providerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.providerapp.Models.OrderData;
import com.example.providerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements DetailsData {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportFragmentManager().beginTransaction().replace(R.id.fram , new Orders()).commit();
    }

    @Override
    public void detailsData(int oder_ID, OrderData orderData) {
        Intent intent = new Intent(getBaseContext() , OrderDetails.class);
        intent.putExtra("oder_ID" , String.valueOf(oder_ID));
        intent.putExtra("orderData" , (Parcelable) orderData);
        startActivity(intent);
    }
}