package com.srabbijan.relationroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.srabbijan.relationroomdb.entities.College
import com.srabbijan.relationroomdb.entities.Student

/*
1 TO n relations
 */
data class CollegeWithStudents(
    @Embedded val college: College,
    @Relation(
        parentColumn = "cName",
        entityColumn = "cName"
    )
    val students: List<Student>
)