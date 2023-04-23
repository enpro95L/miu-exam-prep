package com.powersoft.miuexamprep.model.doa

import androidx.lifecycle.LiveData
import androidx.room.*
import com.powersoft.miuexamprep.model.Course

@Dao
interface CourseDao {
    @Query("select * from course")
    fun all(): List<Course>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Insert
    suspend fun insertAll(vararg courseList: Course)

    @Delete
    suspend fun delete(course: Course)
}