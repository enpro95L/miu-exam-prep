package com.powersoft.miuexamprep

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.powersoft.miuexamprep.model.Course
import com.powersoft.miuexamprep.model.Lesson
import com.powersoft.miuexamprep.model.MCQ
import com.powersoft.miuexamprep.model.doa.CourseDao
import com.powersoft.miuexamprep.model.doa.LessonDao
import com.powersoft.miuexamprep.model.doa.MCQDao
import com.powersoft.miuexamprep.model.doa.UserStatsDao
import com.powersoft.miuexamprep.utils.ConvertorUtils

@Database(entities = [Course::class, Lesson::class, MCQ::class], version = 1)
@TypeConverters(ConvertorUtils::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
    abstract fun lessonDao(): LessonDao
    abstract fun mcqDao(): MCQDao
    abstract fun userStatsDao(): UserStatsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "miu-exam-db"
        ).build()
    }
}