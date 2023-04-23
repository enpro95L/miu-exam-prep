package com.powersoft.miuexamprep.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.powersoft.miuexamprep.db.CourseSeeder
import com.powersoft.miuexamprep.db.DatabaseSeeder
import com.powersoft.miuexamprep.model.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(context: Context): BaseViewModel(context) {
    private var _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>> = _courses!!


    init {
        _courses.value = db.courseDao().all()

        if (CourseSeeder().size != _courses.value?.size) {
            initializeCourses(context)
        }
    }

    private fun initializeCourses(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseSeeder.runCourseSeeder(context)
        }
    }
}