package com.example.a160419133_uts.view

import android.view.View
import com.example.a160419133_uts.model.Recipes
import java.util.*

interface RecipeUpdateClick
{
    fun onRecipeUpdateClick(v: View)
}

interface RecipeUpdateOnClick
{
    fun onRecipeUpdateOnClick(v: View, obj: Recipes)
}

interface RecipeAddClick
{
    fun onRecipeAddClick(v: View)
}

interface DetailRecipeClick
{
    fun onDetailRecipeClick(v: View)
}


interface ProfileUpdateClick
{
    fun onProfileUpdate(v: View)
}
interface RecipeDeleteClick
{
    fun onRecipeDeleteClick(v: View, obj: Recipes)
}

