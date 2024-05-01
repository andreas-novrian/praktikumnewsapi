package com.example.newsapik1

import com.example.newsapik1.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    fun getNews(
        @Query("q") search: String,
        @Query("from") from: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String,
    ): Call<NewsResponse>


}