package com.powersoft.miuexamprep.db.seeders
import com.powersoft.miuexamprep.model.MCQ

object MCQSeeder {
    var mcqs = mutableListOf<MCQ>()
    private fun androidLessons(){
        val androids = AndroidQuestions.questions
        for (lesson in androids.keys){
            var lessonId = lesson
            var questions = androids.get(lessonId)
            var answers = AndroidQuestions.anwers.get(lessonId)!!

            for ((index, question) in questions?.keys!!.withIndex()){
                mcqs.add(
                    MCQ(1, 1, lessonId, question, questions.get(question)!!, answers[index])
                )
            }
        }
    }

    fun getMCQs(): List<MCQ>{
        androidLessons()
        return mcqs
    }
}