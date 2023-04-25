package com.powersoft.miuexamprep.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class MCQ(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    val question: String,
    @ColumnInfo(name = "options") val optionList: List<String>,
    @ColumnInfo(name = "correct_answer") val correctAnswer: String
) : java.io.Serializable {
    @Ignore
    var selectedAnswer: String = ""
}


/* USAGE
* MCQ(null, 1, 2 "Fish is a land animal", listOf("True", "False"), "False")
* MCQ(null, 1, 2"Which is not a country?", listOf("Ghana", "Mongolia", "Nepal", "King"), "King")
* */