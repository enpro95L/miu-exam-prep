package com.powersoft.miuexamprep.viewModels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.db.CourseSeeder
import com.powersoft.miuexamprep.db.DatabaseSeeder
import com.powersoft.miuexamprep.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {
    private var _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>> = _courses!!


    init {
        val db = AppDatabase(application)
        Log.i(
            "try", db.toString()
        )

//        _courses.value = AppDatabase(application).courseDao().all()
//
//        if (CourseSeeder().size != _courses.value?.size) {
//            initializeCourses(application)
//        }
    }

    private fun initializeCourses(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runCourseSeeder(context)
        }
    }
}