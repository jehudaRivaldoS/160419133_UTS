package com.example.a160419133_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160419133_uts.model.MyRecipes
import com.example.a160419133_uts.model.Profile
import com.example.a160419133_uts.model.Recipes

class ListMyRecipe: ViewModel() {
    val myRecipeLD = MutableLiveData<List<MyRecipes>>()

    fun refreshR()
    {
        val recipe1 =
            MyRecipes("1",
                "Ayam goreng lengkuas",
                "ayam, sereh, daun salam, daun jeruk, air, garam halus, bumbu instan ayam lengkuas",
                "ungkep ayam dengan campuran bumbu tadi, setelah itu goreng ayam",
                "https://sweetrip.id/wp-content/uploads/2021/03/89440865_234470661019979_9013155052761496218_n.jpg")
        val recipe2 =
            MyRecipes("2",
                "Nasi Goreng Sosis",
                "Nasi, Bawang putih cincang, Telur, Sosis, Garam, Saus Tomat, minyak goreng",
                "Masukan minyak, bawang, telur orak arik dan masukan nasi garam dan saos campur dan selesai",
                "https://i0.wp.com/tastynesia.com/wp-content/uploads/2019/12/Resep-Nasi-Goreng-Sosis.jpg")

        val recipe = arrayListOf<MyRecipes>(recipe1,recipe2)
        myRecipeLD.value = recipe
    }
}