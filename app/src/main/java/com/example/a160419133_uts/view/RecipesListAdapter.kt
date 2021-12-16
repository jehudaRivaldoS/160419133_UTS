package com.example.a160419133_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419133_uts.R
import com.example.a160419133_uts.databinding.RecipeListItemBinding
import com.example.a160419133_uts.model.Recipes

class RecipesListAdapter(val recipeList: ArrayList<Recipes>):RecyclerView.Adapter<RecipesListAdapter.RecipesViewHolder>(), DetailRecipeClick{
    class RecipesViewHolder(var view: RecipeListItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updateRecipesList(newRecipesList: List<Recipes>){
        recipeList.clear()
        recipeList.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecipeListItemBinding>(inflater,R.layout.recipe_list_item, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.view.recipe = recipeList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onDetailRecipeClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = HomeFragmentDirections.actionHomeToRecipe(uuid)

        Navigation.findNavController(v).navigate(action)
    }
}