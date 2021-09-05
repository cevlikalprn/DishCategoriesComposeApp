package com.cevlikalprn.dishcategoriesapp.dishes

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
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
            .size(120.dp)
    )
}

@Composable
fun ShortDishDetails(dishCategory: String, dishCategoryDescription: String) {

    var isExpanded by remember { mutableStateOf(false)}

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(start = 12.dp)
            .animateContentSize()
    ) {
        Text(text = dishCategory, style = MaterialTheme.typography.h6)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = dishCategoryDescription,
                style = MaterialTheme.typography.subtitle2,
                maxLines = if (isExpanded) 8 else 3
            )
        }
    }

    Icon(
        modifier = Modifier.clickable { isExpanded = !isExpanded },
        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
        contentDescription = null
    )

}

