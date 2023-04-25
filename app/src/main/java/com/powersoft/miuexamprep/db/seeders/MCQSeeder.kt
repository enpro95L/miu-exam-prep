package com.powersoft.miuexamprep.db.seeders
import com.powersoft.miuexamprep.model.MCQ

object MCQSeeder {
    var mcqs = mutableListOf<MCQ>()
    private fun androidLesson2(){
        for ((index, question) in AndroidQuestions.lesson2.keys.withIndex()){
            mcqs.add(
                MCQ(1, 1, 2, question, AndroidQuestions.lesson2.get(question)!!, AndroidQuestions.lesson2Answers[index])
            )
        }
    }

    fun getMCQs(): List<MCQ>{
        androidLesson2()
        return mcqs
    }
}