package com.powersoft.miuexamprep.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Lesson(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "lesson_name") var lessonName: String,
    @ColumnInfo(name = "total_question") var totalQuestion: Int,
    @ColumnInfo(name = "course_id") var courseId: Int,
    @ColumnInfo(name = "percentage_complete") var percentageComplete: Float
) : Serializable