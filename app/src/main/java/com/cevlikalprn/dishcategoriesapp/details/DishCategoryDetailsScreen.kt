package com.cevlikalprn.dishcategoriesapp.details

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cevlikalprn.dishcategoriesapp.dishes.DishPicture
import com.cevlikalprn.dishcategoriesapp.model.Dish


@Composable
fun DishCategoryDetailsScreen(dishId: Int?) {
    Log.i("DishDetails", dishId.toString())
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DishPicture(
            dishImageUrl = "https://www.themealdb.com/images/category/miscellaneous.png",
            dishImageSize = 240.dp
        )
        DishCategoryDescription("Alperen Çevlik")
    }

}

@Composable
fun DishCategoryDescription(dishCateGoryDescription: String) {
    Text(text = dishCateGoryDescription, style = MaterialTheme.typography.body1)
}