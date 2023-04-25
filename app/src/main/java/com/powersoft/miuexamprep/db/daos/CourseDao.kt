package com.powersoft.miuexamprep.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.powersoft.miuexamprep.model.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM COURSE")
    fun all(): LiveData<List<Course>>

    @Query("DELETE FROM COURSE")
    suspend fun resetTable(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Insert
    suspend fun insertAll(vararg courseList: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun delete(course: Course)
}