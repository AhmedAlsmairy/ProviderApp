package com.example.providerapp.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.providerapp.ApiData.ApiClient;
import com.example.providerapp.Models.OrderData;
import com.example.providerapp.Models.OrdersResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersStatusViewModel extends ViewModel {

   public MutableLiveData<List<OrderData>> UnCompletedOrderData = new MutableLiveData<>();
   public MutableLiveData<List<OrderData>> CompletedOrderData = new MutableLiveData<>();

    public void getUnCompletedOrder(String authorization){
        ApiClient.getInstance().getUnCompletedOrder(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> data = new ArrayList<>(response.body().getData());
                UnCompletedOrderData.setValue(data);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }

    public void getCompletedOrder(String authorization){
        ApiClient.getInstance().getCompletedOrder(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> data = new ArrayList<>(response.body().getData());
                CompletedOrderData.setValue(data);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }

}
