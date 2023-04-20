package com.powersoft.miuexamprep.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MCQ(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    var question: String,
    @ColumnInfo(name = "options") var optionList: List<String>,
    @ColumnInfo(name = "correct_answer") var correctAnswer: String
) : java.io.Serializable


/* USAGE
* MCQ(null, 1, 2 "Fish is a land animal", listOf("True", "False"), "False")
* MCQ(null, 1, 2"Which is not a country?", listOf("Ghana", "Mongolia", "Nepal", "King"), "King")
* */