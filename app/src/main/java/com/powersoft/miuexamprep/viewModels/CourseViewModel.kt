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
    init {
        initializeCourses(application)
    }

    private fun initializeCourses(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            var dbCourses = AppDatabase(context).courseDao().all()

            if (CourseSeeder().size != dbCourses.size) {
                DatabaseSeeder.runCourseSeeder(context)
            }
        }
    }

}