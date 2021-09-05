package com.cevlikalprn.dishcategoriesapp.dishes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.dishcategoriesapp.model.Dish
import com.cevlikalprn.dishcategoriesapp.repository.DishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DishCategoriesViewModel(private val repository: DishesRepository = DishesRepository()): ViewModel() {

    val dishesState: MutableState<List<Dish>> = mutableStateOf(emptyList<Dish>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            dishesState.value = getDishes()
        }
    }

    private suspend fun getDishes(): List<Dish>{
        return repository.getDishCategories().dishCategories
    }

}