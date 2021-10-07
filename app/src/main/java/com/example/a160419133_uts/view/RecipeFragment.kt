package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160419133_uts.R
import com.example.a160419133_uts.util.loadImage
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.recipe_list_item.*

class RecipeFragment : Fragment() {      
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        txtJudul.text = "Bolu Panggang"
        txtBahan.text = "Gula, Telur, Baking Powder, Tepung Terigu, Margarin Cair, Vanili"
        txtCara.text = "Campur semua bahan di wadah dan mixer, setelah itu panggah 10 menit dengan suhu 150 celcius"

        imgMakanan.loadImage("https://i2.wp.com/resepkoki.id/wp-content/uploads/2020/08/Resep-Bolu-Mentega.jpg?fit=1070%2C1048&ssl=1", progressBar2)

        btnUpdateR.setOnClickListener {
            val action = RecipeFragmentDirections.actionRecipeUpdate()
            Navigation.findNavController(it).navigate(action)
        }
    }
}