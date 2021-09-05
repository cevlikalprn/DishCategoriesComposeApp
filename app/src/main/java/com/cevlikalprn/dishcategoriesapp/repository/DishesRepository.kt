package com.cevlikalprn.dishcategoriesapp.repository

import com.cevlikalprn.dishcategoriesapp.api.DishesService
import com.cevlikalprn.dishcategoriesapp.model.DishCategory


class DishesRepository {

    suspend fun getDishCategories(): DishCategory{
       return DishesService.api.getDishCategories()
    }

}