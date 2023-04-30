package com.srabbijan.relationroomdb

import androidx.room.*
import com.srabbijan.relationroomdb.entities.College
import com.srabbijan.relationroomdb.entities.Principle
import com.srabbijan.relationroomdb.entities.Student
import com.srabbijan.relationroomdb.entities.relations.CollegeAndPrinciple
import com.srabbijan.relationroomdb.entities.relations.CollegeWithStudents

@Dao
interface CollegeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollege(college: College)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrinciple(principle: Principle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM college WHERE cName = :cName")
    suspend fun getCollegeAndPrincipleWithCollegeName(cName:String):List<CollegeAndPrinciple>

    @Transaction
    @Query("SELECT * FROM college WHERE cName = :cName")
    suspend fun getCollegeWithStudents(cName: String):List<CollegeWithStudents>

}