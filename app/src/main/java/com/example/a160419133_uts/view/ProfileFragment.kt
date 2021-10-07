package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419133_uts.R
import com.example.a160419133_uts.util.loadImage
import com.example.a160419133_uts.viewmodel.ProfileModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.recipe_list_item.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtNameProfile.text = "Name : Jehuda Rivaldo Soetiyono"
        txtEmailProfile.text = "Email : jehuda0911@gmail.com"

        imgProfile.loadImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLV9PJkNYMCpSMzsVX78V9-f-Tt0lv9mXCUw&usqp=CAU",progressBar3)

        btnAbout.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileAbout()
            Navigation.findNavController(it).navigate(action)
        }
        btnUpdate.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileUpdate()
            Navigation.findNavController(it).navigate(action)
        }
    }
}

