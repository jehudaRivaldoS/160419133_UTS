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
import androidx.navigation.Navigation
import com.example.a160419133_uts.R
import com.example.a160419133_uts.databinding.FragmentRecipeBinding
import com.example.a160419133_uts.databinding.FragmentUpdateRecipeBinding
import com.example.a160419133_uts.util.loadImage
import com.example.a160419133_uts.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.recipe_list_item.*

class RecipeFragment : Fragment(), RecipeUpdateClick {
    private  lateinit var  viewModel:DetailRecipeViewModel
    private lateinit var dataBinding:FragmentRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentRecipeBinding>(inflater,R.layout.fragment_recipe,container,false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener = this
        viewModel= ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        val uuid=RecipeFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observerViewModel()
    }

    override fun onRecipeUpdateClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = RecipeFragmentDirections.actionRecipeUpdate(uuid)
        Navigation.findNavController(v).navigate(action)
    }

    fun observerViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            dataBinding.recipe=it
        })
    }
}