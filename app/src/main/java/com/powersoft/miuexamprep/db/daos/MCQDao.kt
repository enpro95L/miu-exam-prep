package com.powersoft.miuexamprep.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.powersoft.miuexamprep.model.MCQ

@Dao
interface MCQDao {
    @Query("select * from mcq where course_id = :courseId and lesson_id = :lessonId")
    suspend fun mcqs(courseId: Int, lessonId: Int): List<MCQ>

    @Insert
    suspend fun add(mcq: MCQ)

    @Query("Select count(*) from mcq")
    fun count(): Int

    @Query("Delete from mcq")
    suspend fun resetTable(): Int
}