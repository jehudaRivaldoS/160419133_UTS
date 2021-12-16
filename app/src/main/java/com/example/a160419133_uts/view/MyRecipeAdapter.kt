package com.example.a160419133_uts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419133_uts.R
import com.example.a160419133_uts.databinding.MyrecipeListItemBinding
import com.example.a160419133_uts.model.Recipes

class MyRecipeAdapter(val recipeList: ArrayList<Recipes>): RecyclerView.Adapter<MyRecipeAdapter.MyRecipesViewHolder>() {
    class MyRecipesViewHolder(var view: MyrecipeListItemBinding) : RecyclerView.ViewHolder(view.root)
    fun updateMyRecipesList(newMyRecipesList: List<Recipes>){
        recipeList.clear()
        recipeList.addAll(newMyRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<MyrecipeListItemBinding>(inflater,R.layout.myrecipe_list_item, parent, false)
        return MyRecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecipesViewHolder, position: Int) {
        holder.view.recipe = recipeList[position]
//        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

//    override fun onRecipeDeleteClick(v: View, obj: Recipes) {
//        TODO("Not yet implemented")
//    }

}