package com.srabbijan.relationroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val sName:String,
    val session:Int,
    val cName: String
)
