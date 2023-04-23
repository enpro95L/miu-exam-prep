package com.powersoft.miuexamprep.model.doa

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.powersoft.miuexamprep.model.Lesson

interface LessonDao {
    @Query("select * from lesson where courseId =  :courseId")
    suspend fun getLessons(courseId: Int): List<Lesson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLesson(lesson: Lesson)
}