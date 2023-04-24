package com.powersoft.miuexamprep.db

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson

object LessonSeeder {
    operator fun invoke(): List<Lesson>{
        return listOf(
            Lesson(1, "Introduction", 10, 1),
            Lesson(2, "Kotlin Fundamentals", 10, 1),
            Lesson(3, "Creating First App", 10, 1),
            Lesson(4,"Activity Lifecycle", 10, 1),
            Lesson(5,"Activities Intents", 10, 1),
            Lesson(6,"User Inputs Controls", 10, 1),

            Lesson(1, "Objects", 10, 2),
            Lesson(2, "Inheritance", 10, 2),
            Lesson(3, "Swing", 10, 2),
            Lesson(4,"Recursions", 10, 2),
            Lesson(5,"Datastructures", 10, 2),
            Lesson(6,"LinkedList", 10, 2)
        )
    }

}