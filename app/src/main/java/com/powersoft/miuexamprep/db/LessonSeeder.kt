package com.powersoft.miuexamprep.db

import com.powersoft.miuexamprep.model.Lesson

object LessonSeeder {
    operator fun invoke(): List<Lesson>{
        return listOf(
            Lesson(1, "Prerequisite Quiz", 15, 1, 0.2F),
            Lesson(2, "Lesson 1 Quiz", 15, 1, 0.2F),
            Lesson(3, "Fun Quiz", 15, 1, 0.2F),
            Lesson(4, "Pre Midterm", 15, 1, 0.2F),
            Lesson(5, "MidTerm", 15, 1, 0.2F),
            Lesson(6, "Lesson 9 Quiz", 15, 1, 0.2F),
            Lesson(7, "Lesson 10 Quiz", 15, 1, 0.2F),
            Lesson(8, "Pre Final", 15, 1, 0.2F),
            Lesson(9, "Final", 15, 1, 0.2F),
            Lesson(10, "MidTerm Quiz", 15, 2, 0.2F),
            Lesson(11, "MidTerm Quiz", 15, 3, 0.2F),

        )
    }
}