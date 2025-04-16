package com.example.herocollection.model

import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitInterface {

    @GET("api/{apiKey}/{id}")
    suspend fun getHeroById(
        @Path("apiKey") apiKey: String,
        @Path("id") id: Int
    ): HeroDto
}