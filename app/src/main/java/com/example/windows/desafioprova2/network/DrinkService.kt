package com.example.windows.desafioprova2.network

import com.example.windows.desafioprova2.entities.Drink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {
    @GET("filter.php")
    fun list(@Query("a") a: String = "Alcoholic") : Call<List<Drink>>
}