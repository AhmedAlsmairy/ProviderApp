package com.example.providerapp.ViewModels;

import androidx.lifecycle.MutableLiveData;

import com.example.providerapp.ApiData.ApiClient;
import com.example.providerapp.Models.AllWorks;
import com.example.providerapp.Models.ProviderRegisterResponse;
import com.example.providerapp.Models.Work;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel {
   public MutableLiveData<List<AllWorks>> allWork = new MutableLiveData<>();

    boolean success;
    public boolean register(String name , String email
            , String password , String phone , int workID){

        ApiClient.getInstance().providerRegister(name, email, password, phone, workID).enqueue(new Callback<ProviderRegisterResponse>() {
            @Override
            public void onResponse(Call<ProviderRegisterResponse> call, Response<ProviderRegisterResponse> response) {
                success = response.isSuccessful();
            }

            @Override
            public void onFailure(Call<ProviderRegisterResponse> call, Throwable t) {

            }
        });
        return success;
    }
    public void getAllWork(){
        ApiClient.getInstance().getAllWork().enqueue(new Callback<Work>() {
            @Override
            public void onResponse(Call<Work> call, Response<Work> response) {
                List<AllWorks> getAllWorks = new ArrayList<>(response.body().getData());
                allWork.setValue(getAllWorks);
            }

            @Override
            public void onFailure(Call<Work> call, Throwable t) {

            }
        });
    }
}
