package com.srabbijan.relationroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.srabbijan.relationroomdb.entities.College
import com.srabbijan.relationroomdb.entities.Principle
import com.srabbijan.relationroomdb.entities.Student

@Database(
    entities = [
        Student::class,
        Principle::class,
        College::class
    ],
    version = 1
)
abstract class CollegeDatabase : RoomDatabase(){

    abstract val dao : CollegeDao

    companion object{
        @Volatile
        private var instance : CollegeDatabase?=null

        fun getInstance(context:Context):CollegeDatabase{
            synchronized(this){
                return instance?: Room.databaseBuilder(
                    context.applicationContext,
                    CollegeDatabase::class.java,
                    "college_db"
                ).build().also {
                    instance =it
                }
            }
        }
    }
}