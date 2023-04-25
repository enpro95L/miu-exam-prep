package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.Lesson

object LessonSeeder {
    operator fun invoke(): List<Lesson>{
        return listOf(
            Lesson(1, "Kotlin Fundamentals", 10, 1),
            Lesson(2, "Creating First App", 10, 1),
            Lesson(3,"Activity Lifecycle", 10, 1),
            Lesson(4,"Activities Intents", 10, 1),
            Lesson(5,"User Inputs Controls", 10, 1),

            Lesson(6, "Objects", 10, 2),
            Lesson(7, "Inheritance", 10, 2),
            Lesson(8, "Swing", 10, 2),
            Lesson(9,"Recursions", 10, 2),
            Lesson(10,"Datastructures", 10, 2),
            Lesson(11,"LinkedList", 10, 2)
        )
    }
}