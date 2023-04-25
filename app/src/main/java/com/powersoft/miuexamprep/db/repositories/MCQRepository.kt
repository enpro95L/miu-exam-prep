package com.powersoft.miuexamprep.db.repositories

import com.powersoft.miuexamprep.db.daos.MCQDao
import com.powersoft.miuexamprep.model.MCQ

class MCQRepository(private val mcqDao: MCQDao) {
    val count: Int = mcqDao.count()

    suspend fun add(mcq: MCQ){
        mcqDao.add(mcq)
    }

    suspend fun getQuestions(courseId: Int, lessonId: Int): List<MCQ>{
       return mcqDao.questions(courseId, lessonId)
    }

    suspend fun resetTable(){
        mcqDao.resetTable()
    }
}