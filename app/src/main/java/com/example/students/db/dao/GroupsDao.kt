package com.example.students.db.dao

import androidx.room.*
import com.example.students.db.Fakultet
import com.example.students.db.Groups


@Dao
interface GroupsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGroup(vararg groups: Groups)

    @Query("SELECT * FROM Groups")
    fun getAllGroup(): List<Groups>

    @Query("SELECT nameGroup FROM Groups")
    fun getNameGroup(): List<String>
    @Query("SELECT idGroup FROM Groups" )
    fun getIdg():List<Groups>

    @Delete
    fun deleteGroup(groups: Groups)
}