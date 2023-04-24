package com.powersoft.miuexamprep.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.model.doa.LessonDao

class LessonsRepository(private val lessonDao: LessonDao) {
    var courseId: Int = 0
    val allLessons: LiveData<List<Lesson>> = lessonDao.all()
    val courseLessons: LiveData<List<Lesson>> = lessonDao.courseLessons(courseId)

    suspend fun addLesson(lesson: Lesson){
        lessonDao.insert(lesson)
    }

    suspend fun resetTable(){
        lessonDao.resetTable()
    }
}