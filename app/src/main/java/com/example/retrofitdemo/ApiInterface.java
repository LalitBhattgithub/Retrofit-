package com.example.retrofitdemo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/todos/1/users")
    Call<List<UserModal>> UserData();
}
