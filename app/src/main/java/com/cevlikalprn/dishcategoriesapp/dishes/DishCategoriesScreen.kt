package com.cevlikalprn.dishcategoriesapp.dishes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.cevlikalprn.dishcategoriesapp.model.Dish


@Composable
fun DishCategoriesScreen() {

    val viewModel: DishCategoriesViewModel = viewModel()
    val dishes = viewModel.dishState.value

    LazyColumn() {
        items(dishes) { dish ->
            DishCategoryCard(dish)
        }
    }

}

@Composable
fun DishCategoryCard(dish: Dish) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), elevation = 8.dp, shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            DishPicture(dish.dishCategoryImageUrl)
            ShortDishDetails(dish.dishCategory, dish.dishCategoryDescription)
        }

    }
}

@Composable
fun DishPicture(dishImageUrl: String) {
    Image(
        painter = rememberImagePainter(dishImageUrl),
        contentDescription = "dish image",
        modifier = Modifier
            .size(128.dp)
            .padding(8.dp)
    )
}

@Composable
fun ShortDishDetails(dishCategory: String, dishCategoryDescription: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp)
    ) {
        Text(text = dishCategory, style = MaterialTheme.typography.h6)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = dishCategoryDescription,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 3
            )
        }
    }

}

