package com.example.a160419133_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a160419133_uts.util.MIGRATION_1_2
import com.example.a160419133_uts.util.MIGRATION_2_3

@Database(entities = arrayOf(Recipes::class), version = 4)
abstract class RecipeDatabase: RoomDatabase()
{
    abstract fun RecipeDao(): Recipes

    companion object
    {
        @Volatile private  var instance: RecipeDatabase ?= null
        private val LOCK = Any();

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext, RecipeDatabase::class.java, "recipedb"
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}