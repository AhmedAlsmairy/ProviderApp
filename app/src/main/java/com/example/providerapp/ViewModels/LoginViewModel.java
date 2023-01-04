package com.example.providerapp.ViewModels;


import com.example.providerapp.ApiData.ApiClient;

import com.example.providerapp.Models.ProviderLoginResponse;




import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel {



    private String token;
    boolean success;
    public boolean login(String email , String password){
        ApiClient.getInstance().providerLogin(email, password).enqueue(new Callback<ProviderLoginResponse>() {
            @Override
            public void onResponse(Call<ProviderLoginResponse> call, Response<ProviderLoginResponse> response) {
                success = response.isSuccessful();
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        token = response.body().getData().getToken();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProviderLoginResponse> call, Throwable t) {

            }
        });
        return success;
    }
    public String getToken(){
        return token;
    }

}
