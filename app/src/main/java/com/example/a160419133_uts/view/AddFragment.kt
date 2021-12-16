package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.a160419133_uts.R
import com.example.a160419133_uts.databinding.FragmentAddBinding
import com.example.a160419133_uts.model.Recipes
import com.example.a160419133_uts.util.RecipeWalker
import com.example.a160419133_uts.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.txtHow
import kotlinx.android.synthetic.main.fragment_add.txtName
import kotlinx.android.synthetic.main.fragment_update_recipe.*
import java.util.concurrent.TimeUnit

class AddFragment : Fragment(), RecipeAddClick {
    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var dataBinding:FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_add,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        dataBinding.recipe = Recipes("","","","")
        dataBinding.listener = this
    }

    override fun onRecipeAddClick(v: View) {
        viewModel.addRecipe(dataBinding.recipe!!)
        Toast.makeText(v.context, "Data added", Toast.LENGTH_LONG).show()
        val myWorkRequest= OneTimeWorkRequestBuilder<RecipeWalker>()
            .setInitialDelay(5,TimeUnit.SECONDS)
            .setInputData(
                workDataOf(
                "title" to "Data Recipe Added",
                "message" to "A new Recipe has been created")
            )
            .build()
        WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
//        Navigation.findNavController(v).popBackStack()
    }
}