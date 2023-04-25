package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.MCQ

object MCQSeeder {
    var mcqs = mutableListOf<MCQ>()
    private fun androidLesson2() {
        for ((index, question) in AndroidQuestions.lesson2.keys.withIndex()) {
            mcqs.add(
                MCQ(
                    index + 1,
                    1,
                    2,
                    question,
                    AndroidQuestions.lesson2[question]!!,
                    AndroidQuestions.lesson2Answers[index]
                )
            )
        }
    }

    private fun androidLesson3() {
        for ((index, question) in AndroidQuestions.lesson3.keys.withIndex()) {
            mcqs.add(
                MCQ(
                    index + 1,
                    1,
                    3,
                    question,
                    AndroidQuestions.lesson3[question]!!,
                    AndroidQuestions.lesson3Answers[index]
                )
            )
        }
    }

    fun getMCQs(): List<MCQ> {
        androidLesson2()
        androidLesson3()
        return mcqs
    }
}