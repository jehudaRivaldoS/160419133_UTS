package com.example.a160419133_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419133_uts.R
import com.example.a160419133_uts.model.MyRecipes
import com.example.a160419133_uts.model.Recipes
import com.example.a160419133_uts.util.loadImage
import kotlinx.android.synthetic.main.myrecipe_list_item.view.*
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class MyRecipeAdapter(val recipeListS: ArrayList<MyRecipes>): RecyclerView.Adapter<MyRecipeAdapter.MyRecipesViewHolder>() {
    class MyRecipesViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateMyRecipesList(newRecipesList: List<MyRecipes>){
        recipeListS.clear()
        recipeListS.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.myrecipe_list_item, parent, false)
        return MyRecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecipesViewHolder, position: Int) {
        holder.view.txtNama.text = recipeListS[position].name
        holder.view.imgMy.loadImage(recipeListS[position].url, holder.view.pb1)
    }

    override fun getItemCount(): Int {
        return recipeListS.size
    }
}