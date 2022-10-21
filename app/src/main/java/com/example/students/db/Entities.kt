package com.example.students.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Fakultet(
    @PrimaryKey(autoGenerate = true) var idFakultet: Int?,
    var nameFakultet: String?
)
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Fakultet::class,
        parentColumns = arrayOf("idFakultet"),
        childColumns = arrayOf("fkFakultet"))
))
data class Groups (
    @PrimaryKey(autoGenerate = true) var idGroup: Int?,
    var nameGroup: String?,
    var fkFakultet: Int?
)
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Groups::class,
        parentColumns = arrayOf("idGroup"),
        childColumns = arrayOf("fkGroup"))
))
data class Students (
    @PrimaryKey(autoGenerate = true) var idStudents: Int?,
    var sName: String?,
    var name:String?,
    var patronymic:String?,
    var dBd:String?,
    var fkGroup: Int?
) {
}
