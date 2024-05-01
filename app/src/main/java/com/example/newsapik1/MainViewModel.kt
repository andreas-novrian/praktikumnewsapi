package com.example.newsapik1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapik1.data.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val newsResponse = MutableLiveData<NewsResponse>()
    val isLoading = MutableLiveData<Boolean>()
    val language = "id"
    val apiKey = "6c49aec93ddb4927ae2e1cf47bd218eb"

    fun getNewsFromAPI(search: String, from: String) {
        isLoading.postValue(true)
        val call = ApiClient.apiService.getNews(search, from, language, apiKey)
        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    newsResponse.postValue(response.body())
                }
                isLoading.postValue(false)
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }
        })
    }
}
