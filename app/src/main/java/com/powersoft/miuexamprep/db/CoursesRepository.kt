package com.powersoft.miuexamprep.db

import androidx.lifecycle.LiveData
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.doa.CourseDao

class CoursesRepository(private val couseDao: CourseDao) {
    val allCourses: LiveData<List<Course>> = couseDao.all()

    suspend fun addCourse(course: Course){
        couseDao.insert(course)
    }

    suspend fun updateCourse(course: Course){
        couseDao.update(course)
    }

    suspend fun deleteCourse(course: Course){
        couseDao.delete(course)
    }

    suspend fun resetTable(){
        couseDao.resetTable()
    }
}