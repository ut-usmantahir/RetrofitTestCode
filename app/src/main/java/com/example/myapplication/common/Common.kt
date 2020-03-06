package com.example.myapplication.common

import com.example.myapplication.`interface`.RetrofitService
import com.example.myapplication.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}
