package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.MCQ

object MCQSeeder {
    var mcqs = mutableListOf<MCQ>()
<<<<<<< HEAD
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
=======
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

    fun getMCQs(): List<MCQ> {
        androidLesson2()
>>>>>>> 45cb7d2394be92ef157b8365bc7038cda25dc991
        return mcqs
    }
}