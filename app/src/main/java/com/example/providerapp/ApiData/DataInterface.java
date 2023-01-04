package com.example.providerapp.ApiData;

import com.example.providerapp.Models.CreateOffer;
import com.example.providerapp.Models.CreateOfferData;
import com.example.providerapp.Models.OrdersResponse;
import com.example.providerapp.Models.OrdersStatus;
import com.example.providerapp.Models.ProviderLoginResponse;
import com.example.providerapp.Models.ProviderRegisterResponse;
import com.example.providerapp.Models.Work;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface DataInterface {

    @FormUrlEncoded
    @POST("auth/register/delivery")
    public Call<ProviderRegisterResponse> providerRegister(@Field("name") String name , @Field("email") String email
            , @Field("password") String password , @Field("phone") String phone , @Field("work_id") int workID);


    @FormUrlEncoded
    @POST("auth/login/delivery")
    public Call<ProviderLoginResponse> providerLogin(@Field("email") String email, @Field("password") String password );

    @GET("all/works")
    public Call<Work> getAllWorks();

    @GET("home/deliver")
    Call<OrdersResponse> getOrders(@Header("Authorization") String authorization);

    @FormUrlEncoded
    @POST("create/Offer")
    public Call<CreateOffer> createOffer(@Field("order_id") int order_id , @Header("Authorization") String authorization);

    @GET("order/un/complete/delivery")
    Call<OrdersResponse> unCompletedOrders(@Header("Authorization") String authorization);

    @GET("order/complete/delivery")
    Call<OrdersResponse> completedOrders(@Header("Authorization") String authorization);
}
