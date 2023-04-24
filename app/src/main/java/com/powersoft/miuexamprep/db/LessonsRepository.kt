package com.powersoft.miuexamprep.db

import androidx.lifecycle.LiveData
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.model.doa.LessonDao

class LessonsRepository(private val lessonDao: LessonDao) {

    val allLessons: LiveData<List<Lesson>> = lessonDao.all()

    suspend fun addLesson(lesson: Lesson){
        lessonDao.insert(lesson)
    }

    suspend fun updateLesson(lesson: Lesson){
        lessonDao.update(lesson)
    }

    suspend fun deleteLesson(lesson: Lesson){
        lessonDao.delete(lesson)
    }

    suspend fun resetTable(){
        lessonDao.resetTable()
        lessonDao.resetTableIds()
    }
}