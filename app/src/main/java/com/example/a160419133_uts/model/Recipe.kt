package com.example.a160419133_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipes(
        @ColumnInfo(name="name")
        var name:String?,
        @ColumnInfo(name="bahan")
        var bahan:String?,
        @ColumnInfo(name="howToMakeIt")
        var howToMakeIt:String?,
        @ColumnInfo(name="url")
        var url:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}