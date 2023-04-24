package com.powersoft.miuexamprep.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.powersoft.miuexamprep.db.*
import com.powersoft.miuexamprep.model.Lesson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonViewModel(application: Application): AndroidViewModel(application) {
    private val _lessons: LiveData<List<Lesson>>
    private val repo: LessonRepository
    private var _courseLessons = MutableLiveData<List<Lesson>>()
    val courseLessons: LiveData<List<Lesson>> = _courseLessons!!

    init {
        repo = LessonRepository(AppDatabase(application).lessonDao())
        _lessons = repo.allLessons

        if (_lessons.value?.size != LessonSeeder().size){
            initializeCourses(application)
        }
    }

    private fun initializeCourses(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runLessonSeeder(context)
        }
    }

    fun setCourseId(courseId: Int) {
        repo.courseId = courseId
        _courseLessons = repo.courseLessons
    }

    fun updateLesson(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repo.addLesson(lesson)
    }
}