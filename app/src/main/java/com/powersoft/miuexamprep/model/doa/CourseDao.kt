package com.powersoft.miuexamprep.model.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.powersoft.miuexamprep.model.Course

@Dao
interface CourseDao {

    @Query("select * from course")
    suspend fun getAllCourses(): List<Course>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCourse(course: Course)

    @Insert
    suspend fun insertAll(vararg courseList: Course)
}