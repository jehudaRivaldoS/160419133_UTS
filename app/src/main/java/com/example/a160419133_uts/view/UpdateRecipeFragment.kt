package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160419133_uts.R
import com.example.a160419133_uts.databinding.FragmentUpdateRecipeBinding
import com.example.a160419133_uts.model.Recipes
import com.example.a160419133_uts.viewmodel.DetailRecipeViewModel

class UpdateRecipeFragment : Fragment(), RecipeUpdateOnClick{
    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var dataBinding: FragmentUpdateRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentUpdateRecipeBinding>(inflater, R.layout.fragment_update_recipe, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        val uuid=UpdateRecipeFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        dataBinding.listener = this

        observerViewModel()
    }

    override fun onRecipeUpdateOnClick(v: View, obj: Recipes) {
        viewModel.update(obj.name.toString(), obj.bahan.toString(), obj.howToMakeIt.toString(), obj.url.toString(), obj.uuid)
        Toast.makeText(v.context,"Todo updated", Toast.LENGTH_SHORT).show()
    }

    fun observerViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe=it
        })
    }
}