package com.powersoft.miuexamprep.db.seeders

import com.powersoft.miuexamprep.model.MCQ

class MCQSeeder {
    operator fun invoke(): List<MCQ>{
        return listOf(
            MCQ(1, 1, 1, "", listOf(), ""),
            MCQ(2, 1, 1, "", listOf(), ""),
            MCQ(3, 1, 1, "", listOf(), "")
        )
    }
}