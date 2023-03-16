package com.example.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiControler {
 private static    ApiControler apiControler;
    Retrofit retrofit;
    public static String url="https://jsonplaceholder.typicode.com";

    public ApiControler() {
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized ApiControler getInstance(){
        if(apiControler==null)
        {
            apiControler=new ApiControler();
        }
        return apiControler;
    }

    ApiInterface getapi(){

        return   retrofit.create(ApiInterface.class);
    }
}
