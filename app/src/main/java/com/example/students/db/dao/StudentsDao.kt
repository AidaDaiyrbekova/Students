package com.example.students.db.dao

import androidx.room.*
import com.example.students.db.Students


@Dao
interface StudentsDao {
    @Insert
    fun addStudent(students: Students)

    @Query("SELECT * FROM Students")
    fun getAllStudent(): Array<Students>

    @Delete
    fun delStudent(payment: Students)
}