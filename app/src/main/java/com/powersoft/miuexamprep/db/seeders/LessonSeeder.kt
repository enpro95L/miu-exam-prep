package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.Lesson

object LessonSeeder {
    operator fun invoke(): List<Lesson>{
        return listOf(
            Lesson(1, "Kotlin Fundamentals", 1),
            Lesson(2, "Creating First App", 1),
            Lesson(3,"Activity Lifecycle", 1),
            Lesson(4,"Activities Intents", 1),
            Lesson(5,"User Inputs Controls", 1),

            Lesson(6, "Objects", 2),
            Lesson(7, "Inheritance", 2),
            Lesson(8, "Swing", 2),
            Lesson(9,"Recursions", 2),
            Lesson(10,"Datastructures", 2),
            Lesson(11,"LinkedList", 2)
        )
    }
}