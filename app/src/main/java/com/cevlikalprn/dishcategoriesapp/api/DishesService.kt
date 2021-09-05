package com.cevlikalprn.dishcategoriesapp.api

import com.cevlikalprn.dishcategoriesapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DishesService {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api: DishesApi by lazy {
       retrofit.create(DishesApi::class.java)
    }
}