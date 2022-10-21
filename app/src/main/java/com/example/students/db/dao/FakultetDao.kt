package com.example.students.db.dao

import androidx.room.*
import com.example.students.db.Fakultet


@Dao
interface FakultetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCategory(vararg fakultet: Fakultet)
    @Query("SELECT * FROM Fakultet")
    fun getAllCategory(): Array<Fakultet>

    @Query("SELECT nameFakultet FROM Fakultet")
    fun getNameCategory(): List<String>

    @Query("SELECT idFakultet FROM Fakultet")
    fun getId(): List<Fakultet>

    @Delete
    fun deleteCategory(fakultet: Fakultet)
}