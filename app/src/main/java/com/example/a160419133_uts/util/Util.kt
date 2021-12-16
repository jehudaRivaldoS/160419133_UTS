package com.example.a160419133_uts.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a160419133_uts.R
import com.example.a160419133_uts.model.RecipeDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

val DB_NAME = "recipedb"

fun buildDb(context: Context): RecipeDatabase
{
    val db = Room.databaseBuilder(context, RecipeDatabase::class.java, DB_NAME).addMigrations(MIGRATION_2_3).build()
    return db
}

val MIGRATION_1_2 = object: Migration(1,2)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE recipes ADD COLUMN howToMakeIt STRING")
    }
}
val MIGRATION_2_3 = object: Migration(2,3)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE recipes ADD COLUMN url TEXT")
    }
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
            .load(url)
            .resize(400, 400)
            .centerCrop()
            .into(this,  object: Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }
                override fun onError(e: Exception?) {
                }
            })
}
@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoURL(v:ImageView,url:String?,pb:ProgressBar)
{
    if(url!=null)
    {
        v.loadImage(url!!,pb)
    }
}


