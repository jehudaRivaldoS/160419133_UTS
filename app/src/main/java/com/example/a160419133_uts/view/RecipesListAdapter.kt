package com.example.a160419133_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419133_uts.R
import com.example.a160419133_uts.model.Recipes
import com.example.a160419133_uts.util.loadImage
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipesListAdapter(val recipeList: ArrayList<Recipes>):RecyclerView.Adapter<RecipesListAdapter.RecipesViewHolder>(){
    class RecipesViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateRecipesList(newRecipesList: List<Recipes>){
        recipeList.clear()
        recipeList.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recipe_list_item, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.view.txtNamaResep.text = recipeList[position].name.toString()
        holder.view.imgRecipe.loadImage(recipeList[position].url.toString(), holder.view.progressBar)

        holder.view.btnView.setOnClickListener {
            val id = recipeList[position].id.toString()
            val action = HomeFragmentDirections.actionHomeToRecipe()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}