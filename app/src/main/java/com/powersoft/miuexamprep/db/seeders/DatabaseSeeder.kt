package com.powersoft.miuexamprep.db.seeders

import android.content.Context
import com.powersoft.miuexamprep.db.AppDatabase
import com.powersoft.miuexamprep.db.repositories.CoursesRepository
import com.powersoft.miuexamprep.db.repositories.LessonsRepository

object DatabaseSeeder {
    suspend fun runCourseSeeder(context: Context){
        val repo = CoursesRepository(AppDatabase(context).courseDao())
        repo.resetTable()

        for (course in CourseSeeder()) {
            repo.addCourse(course)
        }
    }

    suspend fun runLessonSeeder(context: Context){
        val repo = LessonsRepository(AppDatabase(context).lessonDao())
        repo.resetTable()

        for (lesson in LessonSeeder()) {
            repo.addLesson(lesson)
        }
    }
}