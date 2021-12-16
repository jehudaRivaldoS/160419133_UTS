package com.example.a160419133_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160419133_uts.model.Recipes
import com.example.a160419133_uts.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListRecipeViewModel(application: Application): AndroidViewModel(application), CoroutineScope{
    val recipeLD = MutableLiveData<List<Recipes>>()
    private var job = Job()
    fun refresh()
    {
        launch {
            val db = buildDb(getApplication())
            recipeLD.value = db.recipeDao().selectAllRecipes()
        }
    }
    fun clearTask(recipes: Recipes)
    {
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().deleteRecipes(recipes)
        }
    }
    fun clear(uuid:Int)
    {
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().delete(uuid)
        }
    }



    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}