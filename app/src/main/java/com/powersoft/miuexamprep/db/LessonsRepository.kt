package com.powersoft.miuexamprep.db

import androidx.lifecycle.LiveData
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.model.doa.LessonDao

class LessonsRepository(private val lessonDao: LessonDao) {
    val allLessons: LiveData<List<Lesson>> = lessonDao.all()

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