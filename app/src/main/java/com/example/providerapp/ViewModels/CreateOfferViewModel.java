package com.example.providerapp.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.providerapp.ApiData.ApiClient;
import com.example.providerapp.Models.CreateOffer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateOfferViewModel extends ViewModel {

    private boolean success;
    public boolean createOffer(int order_ID , String authorization){
        ApiClient.getInstance().createOffer(order_ID , authorization).enqueue(new Callback<CreateOffer>() {
            @Override
            public void onResponse(Call<CreateOffer> call, Response<CreateOffer> response) {
                if (response.isSuccessful()){
                    success = true;
                }
            }

            @Override
            public void onFailure(Call<CreateOffer> call, Throwable t) {

            }
        });
        return success;
    }

}
