package com.example.providerapp.ApiData;

import com.example.providerapp.Models.ProviderLoginResponse;
import com.example.providerapp.Models.ProviderRegisterResponse;
import com.example.providerapp.Models.Work;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
}
