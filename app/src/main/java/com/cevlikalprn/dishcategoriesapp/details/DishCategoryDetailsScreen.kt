package com.cevlikalprn.dishcategoriesapp.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cevlikalprn.dishcategoriesapp.dishes.DishCategoriesViewModel
import com.cevlikalprn.dishcategoriesapp.dishes.DishPicture
import com.cevlikalprn.dishcategoriesapp.dishes.MyAppBar
import com.cevlikalprn.dishcategoriesapp.util.Constants


@Composable
fun DishCategoryDetailsScreen(navController: NavController ,dishId: Int?) {

    var catchDish = Constants.tempDish
    val viewModel: DishCategoriesViewModel = viewModel()
    val dishes = viewModel.dishState.value
    for (dish in dishes) {
        if (dishId == dish.dishCategoryId) {
            catchDish = dish
        }
    }
    Scaffold(topBar = {
        MyAppBar(
            title = "Dish Details",
            icon = Icons.Default.ArrowBack,
            iconClickAction = {
                navController.navigateUp()
            })
    }, ) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top= 48.dp))
        DishPicture(
            dishImageUrl = catchDish.dishCategoryImageUrl,
            dishImageSize = 240.dp
        )
        DishCategoryDescription(catchDish.dishCategory, catchDish.dishCategoryDescription)
    }

}

@Composable
fun DishCategoryDescription(dishCategory: String, dishDescription: String) {
    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dishCategory,
            style = MaterialTheme.typography.h5,
        )
        Spacer(modifier = Modifier.padding(24.dp))
        Text(
            text = dishDescription,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}