package com.powersoft.miuexamprep.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.db.seeders.CourseSeeder
import com.powersoft.miuexamprep.db.repositories.CoursesRepository
import com.powersoft.miuexamprep.db.seeders.DatabaseSeeder
import com.powersoft.miuexamprep.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {
    val courses: LiveData<List<Course>>
    private val repo: CoursesRepository

    init {
        repo = CoursesRepository(AppDatabase(application).courseDao())
        courses = repo.allCourses

        if (courses.value?.size != CourseSeeder().size){
            initializeCourses(application)
        }
    }

    private fun initializeCourses(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runCourseSeeder(context)
        }
    }

    fun addCourse(course: Course) = viewModelScope.launch(Dispatchers.IO) {
        repo.addCourse(course)
    }

    fun updateCourse(course: Course) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateCourse(course)
    }

    fun deleteCourse(course: Course) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteCourse(course)
    }

}