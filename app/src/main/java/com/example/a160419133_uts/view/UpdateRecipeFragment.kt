package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160419133_uts.R
import com.example.a160419133_uts.viewmodel.ListRecipeModel
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.fragment_update_recipe.*

class UpdateRecipeFragment : Fragment() {
    private lateinit var viewModel: ListRecipeModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnUpdateUR.setOnClickListener {
            val action = UpdateRecipeFragmentDirections.actionDialog()
            Navigation.findNavController(it).navigate(action)
        }
    }
}