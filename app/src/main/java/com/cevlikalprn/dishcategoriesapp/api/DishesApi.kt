package com.cevlikalprn.dishcategoriesapp.api

import com.cevlikalprn.dishcategoriesapp.model.DishCategory
import retrofit2.http.GET

interface DishesApi {

    @GET("categories.php")
    suspend fun getDishCategories(): DishCategory
}