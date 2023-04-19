package com.powersoft.miuexamprep.model

import java.io.Serializable

data class Lesson(
    var id: Int,
    var lessonName: String,
    var totalQuestion: Int,
    var courseId: Int,
    var percentageComplete: Float
) : Serializable