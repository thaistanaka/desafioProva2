package com.example.windows.teste.network

import com.example.windows.teste.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {
    @GET("filter.php")
    fun list(@Query("a") a: String = "Alcoholic") : Call<DrinkList>

    @GET("random.php")
    fun random() : Call<DrinkList>

    @GET("lookup.php?")
    fun id_drink(@Query("i") i : String) : Call<DrinkList>

    @GET("search.php?")
    fun busca(@Query("s") s: String) : Call<DrinkList>

}