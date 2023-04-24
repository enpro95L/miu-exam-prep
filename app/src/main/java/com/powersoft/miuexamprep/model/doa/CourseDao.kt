package com.powersoft.miuexamprep.model.doa

import androidx.lifecycle.LiveData
import androidx.room.*
import com.powersoft.miuexamprep.model.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM COURSE ORDER BY ID DESC")
    fun all(): LiveData<List<Course>>

    @Query("DELETE FROM COURSE")
    suspend fun resetTable(): Int

    @Query("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='COURSE'")
    suspend fun resetTableIds(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Insert
    suspend fun insertAll(vararg courseList: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun delete(course: Course)
}