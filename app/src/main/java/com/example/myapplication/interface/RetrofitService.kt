package com.example.myapplication.`interface`

import retrofit2.Call
import com.example.myapplication.model.Movie
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getAllMovieList(): Call<MutableList<Movie>>
}