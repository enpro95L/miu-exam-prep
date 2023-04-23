package com.powersoft.miuexamprep.model.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.powersoft.miuexamprep.model.UserStats

@Dao
interface UserStatsDao {
    @Query("select percentage_complete from user_stats where course_id = :courseId and lesson_id = :lessonId")
    suspend fun getCompletePercentage(courseId: Int, lessonId: Int): Float

    @Insert
    suspend fun addUserStat(userStats: UserStats)
}