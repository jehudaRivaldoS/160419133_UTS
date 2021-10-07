package com.example.a160419133_uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160419133_uts.model.Recipes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListRecipeModel(application: Application) : AndroidViewModel(application) {
    val recipeLD = MutableLiveData<List<Recipes>>()

    /*val TAG = "volleyTag"
    private var queue: RequestQueue?= null*/
    fun refresh()
    {
        /*queue = Volley.newRequestQueue(getApplication())
        var url = "http://192.168.100.2/anmp.php"

        val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val sType = object : TypeToken<List<Recipes>>() { }.type
                    val result = Gson().fromJson<List<Recipes>>(response, sType)
                    recipeLD.value = result
                    Log.d("showvoley", result.toString())
                },
                {
                    Log.d("showvoley", it.toString())
                })
        stringRequest.tag = TAG
        queue?.add(stringRequest)*/

        val recipe1 =
                Recipes("1",
                        "Bolu Panggang",
                        "Gula, Telur, Baking Powder, Tepung Terigu, Margarin Cair, Vanili",
                        "Campur semua bahan di wadah dan mixer, setelah itu panggah 10 menit dengan suhu 150 celcius",
                        "https://i2.wp.com/resepkoki.id/wp-content/uploads/2020/08/Resep-Bolu-Mentega.jpg?fit=1070%2C1048&ssl=1")
        val recipe2 =
                Recipes("2",
                        "Nasi Goreng Sosis",
                        "Nasi, Bawang putih cincang, Telur, Sosis, Garam, Saus Tomat, minyak goreng",
                        "Masukan minyak, bawang, telur orak arik dan masukan nasi garam dan saos campur dan selesai",
                        "https://i0.wp.com/tastynesia.com/wp-content/uploads/2019/12/Resep-Nasi-Goreng-Sosis.jpg")
        val recipe3 =
                Recipes("3",
                        "Mie Goreng Sosis",
                        "Mie, Bawang putih cincang, Telur, Sosis, Garam, Saus Tomat, minyak goreng",
                        "Masukan minyak, bawang, telur orak arik dan masukan air Mie garam dan saos campur dan selesai",
                        "https://img-global.cpcdn.com/recipes/eb97feadf4b169ab/751x532cq70/mie-goreng-sosis-foto-resep-utama.jpg")
        val recipe = arrayListOf<Recipes>(recipe1,recipe2,recipe3)
        recipeLD.value = recipe
    }
    /*override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }*/
}