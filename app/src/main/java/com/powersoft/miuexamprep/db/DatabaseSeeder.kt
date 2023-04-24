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

    suspend fun runLessonSeeder(context: Context){
        val repo = LessonRepository(AppDatabase(context).lessonDao())
        repo.resetTable()

        for (lesson in LessonSeeder()) {
            repo.addLesson(lesson)
        }
    }
}