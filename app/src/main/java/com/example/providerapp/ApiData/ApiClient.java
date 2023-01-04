package com.example.providerapp.ApiData;

import com.example.providerapp.Models.CreateOffer;
import com.example.providerapp.Models.OrdersResponse;
import com.example.providerapp.Models.OrdersStatus;
import com.example.providerapp.Models.ProviderLoginResponse;
import com.example.providerapp.Models.ProviderRegisterResponse;
import com.example.providerapp.Models.Work;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BaseULR = "https://studentucas.awamr.com/api/";
    DataInterface dataInterface;
    private static ApiClient Instance;

    private ApiClient(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory
                        (GsonConverterFactory.create())
                .baseUrl(BaseULR)
                .build();
        dataInterface = retrofit.create(DataInterface.class);

    }

    public static ApiClient getInstance() {
        if (Instance == null){
            Instance = new ApiClient();
        }
        return Instance;
    }


    public Call<Work> getAllWork(){
        return dataInterface.getAllWorks();
    }

    public Call<ProviderRegisterResponse> providerRegister(String name , String email
            , String password , String phone , int workID){
        return dataInterface.providerRegister(name, email, password, phone, workID);
    }

    public Call<ProviderLoginResponse> providerLogin(String email
            , String password){
        return dataInterface.providerLogin(email, password);
    }

    public Call<OrdersResponse> getOrders(String authorization){
        return dataInterface.getOrders(authorization);
    }

    public Call<OrdersResponse> getUnCompletedOrder(String authorization){
        return dataInterface.unCompletedOrders(authorization);
    }
    public Call<OrdersResponse> getCompletedOrder(String authorization){
        return dataInterface.completedOrders(authorization);
    }

    public Call<CreateOffer> createOffer(int order_ID , String authorization){
        return dataInterface.createOffer(order_ID , authorization);
    }
}
