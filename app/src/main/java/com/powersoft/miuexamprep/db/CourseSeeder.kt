package com.powersoft.miuexamprep.db

import com.powersoft.miuexamprep.model.Course

object CourseSeeder {
    operator fun invoke(): List<Course>{
        return listOf(
            Course("Android Programming", "android"),
            Course("Serverside Programming", "nodejs"),
            Course("Java Fundamental Programming", "java"),
            Course("Advanced Java Programming", "java")
        )
    }
}