package com.example.basicprogramming.retrofitappdemo.apiservices;

import com.example.basicprogramming.retrofitappdemo.model.Users;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("/userrestapi/v1/addusers")
    Call<Users> createUsers(@FieldMap Map<String, String> params);

    @GET("/userrestapi/v1/users")
    Call<List<Users>> getAllUsers();
}
