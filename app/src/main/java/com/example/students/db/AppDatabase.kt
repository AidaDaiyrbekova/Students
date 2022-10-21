package com.example.students.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.students.db.dao.FakultetDao
import com.example.students.db.dao.GroupsDao
import com.example.students.db.dao.StudentsDao

@Database(entities = [Fakultet::class, Groups::class, Students::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun FakultetDao(): FakultetDao
    abstract fun GroupsDao(): GroupsDao
    abstract fun StudentsDao(): StudentsDao
}