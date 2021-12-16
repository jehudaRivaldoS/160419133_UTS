package com.example.a160419133_uts.model

import androidx.room.*

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipes: Recipes)

    @Query("SELECT * FROM recipes")
    suspend fun selectAllRecipes(): List<Recipes>

    @Query("SELECT * FROM recipes WHERE uuid = :id")
    suspend fun selectRecipes(id:Int): Recipes

    @Query("UPDATE recipes SET name= :name, bahan = :bahan, howToMakeIt = :how, url = :url WHERE uuid = :id")
    suspend fun update(name:String, bahan:String, how:String, url:String, id: Int)

    @Query("DELETE FROM recipes WHERE uuid= :id")
    suspend fun delete(id:Int)

    @Delete
    suspend fun deleteRecipes(recipes: Recipes)
}