package com.srabbijan.relationroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Principle(
    @PrimaryKey(autoGenerate = false)
    var pName:String,
    var cName:String
)
