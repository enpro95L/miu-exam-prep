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
    fun allLessonsCount(): LiveData<Int>

    @Query("select *, (select count(*) from mcq where course_id = :courseId and lesson_id = id) as activities_count from lesson where course_id = :courseId")
    suspend fun getCourseLessons(courseId: Int): List<Lesson>

    @Query("DELETE FROM LESSON")
    suspend fun resetTable(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)
}