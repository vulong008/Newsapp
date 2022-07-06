package com.example.newsapp.API;

import com.example.newsapp.ApiInterFace;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static Retrofit retrofit = null;

    public static ApiInterFace getApiInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(ApiInterFace.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterFace.class);
    }
}
