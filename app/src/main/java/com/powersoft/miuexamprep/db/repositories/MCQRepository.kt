package com.powersoft.miuexamprep.db.repositories

import androidx.lifecycle.LiveData
import com.powersoft.miuexamprep.db.daos.MCQDao
import com.powersoft.miuexamprep.model.MCQ

class MCQRepository(private val mcqDao: MCQDao) {
    val count: LiveData<Int> = mcqDao.count()

    suspend fun add(mcq: MCQ){
        mcqDao.add(mcq)
    }

    suspend fun mcqs(courseId: Int, lessonId: Int): List<MCQ>{
       return mcqDao.mcqs(courseId, lessonId)
    }

    suspend fun resetTable(){
        mcqDao.resetTable()
    }
}