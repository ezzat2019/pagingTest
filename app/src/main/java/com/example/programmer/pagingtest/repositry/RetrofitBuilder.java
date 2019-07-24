package com.example.programmer.pagingtest.repositry;

import com.example.programmer.pagingtest.ui.PhotoApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static final RetrofitBuilder ourInstance = new RetrofitBuilder();
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;

    public PhotoApi getApi() {
        return api;
    }

    private PhotoApi api;

    public static RetrofitBuilder getInstance() {
        return ourInstance;
    }

    private RetrofitBuilder() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        api = retrofit.create(PhotoApi.class);
    }
}
