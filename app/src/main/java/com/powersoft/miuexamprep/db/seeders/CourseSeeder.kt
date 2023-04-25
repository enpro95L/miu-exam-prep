package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Course

object CourseSeeder {
    operator fun invoke(): List<Course> {
        return listOf(
            Course(1, "Android Programming", R.drawable.android),
            Course(2, "Java Fundamental Programming", R.drawable.java),
            Course(3, "Serverside Programming", R.drawable.nodejs),
            Course(4, "Advanced Java Programming", R.drawable.java),
            Course(5, "Algorithm", R.drawable.algorithm),
            Course(6, "Software Architecture", R.drawable.sa)
        )
    }
}