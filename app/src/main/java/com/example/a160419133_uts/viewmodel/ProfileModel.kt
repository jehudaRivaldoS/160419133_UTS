package com.example.a160419133_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160419133_uts.model.Profile

class ProfileModel : ViewModel() {
    val profileLD = MutableLiveData<List<Profile>>()

    fun refreshP()
    {
        /*val profile =
                Profile("1",
                        "c",
                        "jehuda0911@gmail.com",
                        "data:image/jpeg;base64,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")

        val profiles = arrayListOf<Profile>(profile)

        profileLD.value = profiles*/
    }
}