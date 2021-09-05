package com.cevlikalprn.dishcategoriesapp.details

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
fun DishCategoryDetailsScreen(dish: Dish) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DishPicture(
            dishImageUrl = dish.dishCategoryImageUrl,
            dishImageSize = 240.dp
        )
        DishCategoryDescription(dish.dishCategoryDescription)
    }

}

@Composable
fun DishCategoryDescription(dishCateGoryDescription: String) {
    Text(text = dishCateGoryDescription, style = MaterialTheme.typography.body1)
}