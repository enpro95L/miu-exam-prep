package com.powersoft.miuexamprep.db

import android.content.Context

object DatabaseSeeder {
    suspend fun runCourseSeeder(context: Context){
        val db = AppDatabase(context)
        for (course in CourseSeeder()) {
            db.courseDao().delete(course)
            db.courseDao().insert(course)
        }
    }
}