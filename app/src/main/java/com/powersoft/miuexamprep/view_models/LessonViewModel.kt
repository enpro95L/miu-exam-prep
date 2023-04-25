package com.powersoft.miuexamprep.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.powersoft.miuexamprep.db.*
import com.powersoft.miuexamprep.db.repositories.LessonsRepository
import com.powersoft.miuexamprep.db.seeders.DatabaseSeeder
import com.powersoft.miuexamprep.db.seeders.LessonSeeder
import com.powersoft.miuexamprep.model.Lesson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonViewModel(application: Application): AndroidViewModel(application) {
    private val repo: LessonsRepository

    init {
        repo = LessonsRepository(AppDatabase(application).lessonDao())

        if (repo.allLessonsCount.value != LessonSeeder().size){
            initializeLessons(application)
        }
    }

    private fun initializeLessons(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runLessonSeeder(context)
        }
    }

    suspend fun getCourseLessons(courseId: Int): List<Lesson>{
        return repo.getCourseLessons(courseId)
    }

    fun updateLesson(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repo.addLesson(lesson)
    }
}