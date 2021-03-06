package com.cevlikalprn.dishcategoriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.cevlikalprn.dishcategoriesapp.details.DishCategoryDetailsScreen
import com.cevlikalprn.dishcategoriesapp.dishes.DishCategoriesScreen
import com.cevlikalprn.dishcategoriesapp.model.Dish
import com.cevlikalprn.dishcategoriesapp.model.DishCategory
import com.cevlikalprn.dishcategoriesapp.ui.theme.DishCategoriesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DishCategoriesAppTheme {
                MyAppNavigation()
            }
        }
    }
}

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dish_categories_screen") {
        composable(route = "dish_categories_screen") {
            DishCategoriesScreen(navController = navController)
        }
        composable(
            route = "dish_category_details_screen" + "/{dishId}", arguments = listOf(
                navArgument("dishId", builder = {
                    type = NavType.IntType
                })
            )
        ) { entry ->
            DishCategoryDetailsScreen(navController, entry.arguments?.getInt("dishId"))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DishCategoriesAppTheme {

    }
}