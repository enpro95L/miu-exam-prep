package com.powersoft.miuexamprep.db.seeders

import android.util.Log
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
                Log.i("test1", lessonId.toString())
                Log.i("test2", question.toString())

                mcqs.add(
                    MCQ(1, 1, lessonId, question, questions.get(question)!!, answers[index])
                )
            }
        }
    }

    fun getMCQs(): List<MCQ>{
        androidLessons()
        Log.i("test3", mcqs.toString())
        return mcqs
    }
}