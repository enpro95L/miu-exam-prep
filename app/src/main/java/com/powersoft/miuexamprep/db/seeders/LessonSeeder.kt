package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.Lesson

object LessonSeeder {
    operator fun invoke(): List<Lesson>{
        return listOf(
            Lesson(1, "Kotlin Fundamentals", 1, 10),
            Lesson(2, "Creating First App", 1, 10),
            Lesson(3,"Activity Lifecycle", 1, 10),
            Lesson(4,"Activities Intents", 1, 10),
            Lesson(5,"User Inputs Controls", 1, 10),

            Lesson(6, "Objects", 2, 10),
            Lesson(7, "Inheritance", 2, 10),
            Lesson(8, "Swing", 2, 10),
            Lesson(9,"Recursions", 2, 10),
            Lesson(10,"Datastructures", 2, 10),
            Lesson(11,"LinkedList", 2, 10)
        )
    }
}