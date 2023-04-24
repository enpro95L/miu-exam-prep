package com.powersoft.miuexamprep.db

import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.model.Course

object CourseSeeder {
    operator fun invoke(): List<Course>{
        return listOf(
            Course("Android Programming", R.drawable.android),
            Course("Serverside Programming", R.drawable.nodejs),
            Course("Java Fundamental Programming", R.drawable.java),
            Course("Advanced Java Programming", R.drawable.java),
            Course("Algorithm", R.drawable.algorithm),
            Course("Software Architecture", R.drawable.sa)
        )
    }
}