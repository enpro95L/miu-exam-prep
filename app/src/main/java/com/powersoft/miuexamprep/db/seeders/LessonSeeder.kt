package com.powersoft.miuexamprep.db.seeders

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

            Lesson(7, "Objects", 10, 2),
            Lesson(8, "Inheritance", 10, 2),
            Lesson(9, "Swing", 10, 2),
            Lesson(10,"Recursions", 10, 2),
            Lesson(11,"Datastructures", 10, 2),
            Lesson(12,"LinkedList", 10, 2)
        )
    }
}