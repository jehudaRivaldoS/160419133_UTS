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
import com.example.a160419133_uts.viewmodel.ListMyRecipe
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_my_recipe.*


class MyRecipeFragment : Fragment() {
    private lateinit var viewModel: ListMyRecipe
    private val myRecipeListAdapter = MyRecipeAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListMyRecipe::class.java)
        viewModel.refreshR()

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = myRecipeListAdapter

        refresh.setOnRefreshListener {
            recycler.visibility = View.GONE
            viewModel.refreshR()
            refresh.isRefreshing = false
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.myRecipeLD.observe(viewLifecycleOwner, Observer {
            myRecipeListAdapter.updateMyRecipesList(it)
        })
    }
}