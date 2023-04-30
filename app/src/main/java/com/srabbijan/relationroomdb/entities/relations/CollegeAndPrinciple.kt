package com.srabbijan.relationroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.srabbijan.relationroomdb.entities.College
import com.srabbijan.relationroomdb.entities.Principle

/*
1 TO 1 relations
 */
data class CollegeAndPrinciple(
    @Embedded val college: College,
    @Relation(
        parentColumn = "cName",
        entityColumn = "cName"
    )
    val principle: Principle

)