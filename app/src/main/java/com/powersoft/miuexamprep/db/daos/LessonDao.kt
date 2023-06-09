package com.powersoft.miuexamprep.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.powersoft.miuexamprep.model.Lesson

@Dao
interface LessonDao {
    @Query("SELECT COUNT(*) FROM LESSON")
    suspend fun allLessonsCount(): Int

    @Query("select * from lesson where course_id = :courseId")
    suspend fun getCourseLessons(courseId: Int): List<Lesson>

    @Query("DELETE FROM LESSON")
    suspend fun resetTable(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)
}