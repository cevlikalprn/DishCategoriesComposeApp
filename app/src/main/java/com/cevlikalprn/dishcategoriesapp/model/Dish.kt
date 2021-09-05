package com.cevlikalprn.dishcategoriesapp.model

import com.google.gson.annotations.SerializedName

data class Dish(
    @SerializedName("idCategory")
    val dishCategoryId: Int,
    @SerializedName("strCategory")
    val dishCategory: String,
    @SerializedName("strCategoryThumb")
    val dishCategoryImageUrl: String,
    @SerializedName("strCategoryDescription")
    val dishCategoryDescription: String
)
