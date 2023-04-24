package com.powersoft.miuexamprep.model.doa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
    fun courseLessons(courseId: Int): MutableLiveData<List<Lesson>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)

}