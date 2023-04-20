package com.powersoft.miuexamprep.model.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.powersoft.miuexamprep.model.MCQ

@Dao
interface MCQDao {

    @Query("select * from mcq where course_id = :courseId and lesson_id = :lessonId")
    suspend fun getQuestions(courseId: Int, lessonId: Int): List<MCQ>

    @Insert
    suspend fun insertMCQ(mcq: MCQ)
}