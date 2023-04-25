package com.powersoft.miuexamprep.db.repositories

import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.db.daos.LessonDao

class LessonsRepository(private val lessonDao: LessonDao) {
    val allLessonsCount: Int = lessonDao.allLessonsCount()

    suspend fun addLesson(lesson: Lesson){
        lessonDao.insert(lesson)
    }

    suspend fun getCourseLessons(courseId: Int): List<Lesson>{
       return lessonDao.getCourseLessons(courseId)
    }

    suspend fun resetTable(){
        lessonDao.resetTable()
    }
}