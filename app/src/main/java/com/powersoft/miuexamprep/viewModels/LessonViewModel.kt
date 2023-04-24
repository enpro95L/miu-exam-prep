package com.powersoft.miuexamprep.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.powersoft.miuexamprep.db.*
import com.powersoft.miuexamprep.model.Lesson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonViewModel(application: Application): AndroidViewModel(application) {
    val lessons: LiveData<List<Lesson>>
    val repo: LessonsRepository

    init {
        repo = LessonsRepository(AppDatabase(application).lessonDao())
        lessons = repo.allLessons

        if(lessons.value?.size != LessonSeeder().size) {
            initializeLessons(application)
        }
    }

    private fun initializeLessons(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runLessonSeeder(context)
        }
    }

    fun addLesson(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repo.addLesson(lesson)
    }

    fun updateLesson(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateLesson(lesson)
    }

    fun deleteLesson(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteLesson(lesson)
    }
}