package com.powersoft.miuexamprep.model.doa

import androidx.lifecycle.LiveData
import androidx.room.*
import com.powersoft.miuexamprep.model.Lesson

@Dao
interface LessonDao {
    @Query("SELECT * FROM LESSON ORDER BY ID DESC")
    fun all(): LiveData<List<Lesson>>

    @Query("DELETE FROM LESSON")
    suspend fun resetTable(): Int

    @Query("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='LESSON'")
    suspend fun resetTableIds(): Int

    @Query("select * from lesson where course_id = :courseId")
    suspend fun getLessons(courseId: Int): List<Lesson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLesson(lesson: Lesson)

    @Insert
    suspend fun insertAll(vararg lessonList: Lesson)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)

    @Update
    suspend fun update(lesson: Lesson)

    @Delete
    suspend fun delete(lesson: Lesson)

}