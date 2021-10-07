package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160419133_uts.R
import com.example.a160419133_uts.viewmodel.ListRecipeModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: ListRecipeModel
    private val recipeListAdapter = RecipesListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListRecipeModel::class.java)
        viewModel.refresh()

        recView1.layoutManager = LinearLayoutManager(context)
        recView1.adapter = recipeListAdapter

        rLayout.setOnRefreshListener {
            recView1.visibility = View.GONE
            viewModel.refresh()
            rLayout.isRefreshing = false
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            recipeListAdapter.updateRecipesList(it)
        })
    }
}