package com.example.newsapik1.data

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>


)
