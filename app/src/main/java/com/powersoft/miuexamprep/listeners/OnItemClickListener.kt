package com.powersoft.miuexamprep.listeners

import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson

interface OnItemClickListener {
    fun onClicked(lesson: Lesson, course: Course)
}