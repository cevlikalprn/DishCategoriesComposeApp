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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.cevlikalprn.dishcategoriesapp.dishes.DishCategoriesScreen
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
    DishCategoriesScreen()
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DishCategoriesAppTheme {

    }
}