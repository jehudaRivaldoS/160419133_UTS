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

class DetailRecipeViewModel(application: Application) : AndroidViewModel(application), CoroutineScope{
    val recipeLD = MutableLiveData<Recipes>()
    private val job = Job()

    fun addRecipe(recipes: Recipes) {
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().insertAll(recipes)
        }
    }

    fun fetch(uuid: Int) {
        launch {
            val db = buildDb(getApplication())
            recipeLD.value = db.recipeDao().selectRecipes(uuid)
        }
    }

    fun update(name: String, bahan: String, howToMakeIt: String, url: String, uuid: Int)
    {
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().update(name, bahan, howToMakeIt, url,uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

//    override fun onDetailRecipeClick(v: View) {
//        TODO("Not yet implemented")
//    }
}