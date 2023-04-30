package com.srabbijan.relationroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class College(
    @PrimaryKey(autoGenerate = false)
    var cName:String
)
