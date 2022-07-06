package com.example.newsapp;

import com.example.newsapp.Model.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {
    String baseUrl="https://newsapi.org/v2/";
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=fe7b771999d24d46911599c9512a8832
    @GET("top-headlines")
    Call<mainNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<mainNews> getCategoriNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

}
