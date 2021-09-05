package com.cevlikalprn.dishcategoriesapp.model

import com.google.gson.annotations.SerializedName

data class DishCategory(
    @SerializedName("categories")
    val dishCategories: List<Dish>
)