package com.example.providerapp.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.providerapp.ApiData.ApiClient;
import com.example.providerapp.Models.AllWorks;
import com.example.providerapp.Models.OrderData;
import com.example.providerapp.Models.OrdersResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersViewModel extends ViewModel {

   public MutableLiveData<List<OrderData>> orderData = new MutableLiveData<>();

   public void getOrders(String authorization){
        ApiClient.getInstance().getOrders(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> getAllOrders = new ArrayList<>(response.body().getData());
                orderData.setValue(getAllOrders);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }


}
