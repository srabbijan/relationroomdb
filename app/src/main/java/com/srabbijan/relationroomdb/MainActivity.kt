package com.srabbijan.relationroomdb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.srabbijan.relationroomdb.entities.College
import com.srabbijan.relationroomdb.entities.Principle
import com.srabbijan.relationroomdb.entities.Student
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dao = CollegeDatabase.getInstance(this).dao

        val principle = listOf<Principle>(
            Principle("p1","c1"),
            Principle("p2","c2"),
            Principle("p3","c3")
        )
        val college = listOf(
            College("c1"),
            College("c2"),
            College("c3")
        )
        val student = listOf(
            Student("s1",2020,"c1"),
            Student("s2",2020,"c1"),

            Student("s3",2021,"c2"),

            Student("s4",2022,"c3"),
            Student("s5",2023,"c3"),
        )

        lifecycleScope.launch {
            principle.forEach{
                dao.insertPrinciple(it)
            }
            college.forEach {
                dao.insertCollege(it)
            }
            student.forEach {
                dao.insertStudent(it)
            }

            val collegeWithStudents = dao.getCollegeWithStudents("c3")
            collegeWithStudents.forEach {
                it.students.forEach {
                    Log.d("TAG1", it.sName)
                }
            }

            val collegeWithPrinciple = dao.getCollegeAndPrincipleWithCollegeName("c3")

            collegeWithPrinciple.forEach {
                    Log.d("TAG2", it.principle.pName)
            }

        }
    }
}