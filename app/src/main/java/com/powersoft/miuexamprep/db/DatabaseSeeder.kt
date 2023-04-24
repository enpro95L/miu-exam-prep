package com.powersoft.miuexamprep.db

import android.content.Context

object DatabaseSeeder {
    suspend fun runCourseSeeder(context: Context){
        val repo = CoursesRepository(AppDatabase(context).courseDao())
        repo.resetTable()
        for (course in CourseSeeder()) {
            repo.addCourse(course)
        }
    }
}