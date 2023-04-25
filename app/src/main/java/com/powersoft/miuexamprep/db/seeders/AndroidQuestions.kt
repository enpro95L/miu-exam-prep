package com.powersoft.miuexamprep.db.seeders

object AndroidQuestions {
    val lesson2: Map<String, List<String>> = mapOf(
        "Which of the following is not a benefit of Kotlin" to listOf(
            "A. Expressive and concise", "B.Verbose", "C. Safer Code"
        ),
        "The keyword, val, is used for immutable variables" to listOf("A.True", "B.False"),
        "The keyword, when, is the replacement of switch in other languages" to listOf("A.True", "B.False"),
        "'for (i in 1..5) print(i)' is valid statement " to listOf("A.True", "B.False"),
        "In Kotlin, variables can be null by default" to listOf("A.True", "B.False"),
        "Allow null-pointer exceptions using the !! operator" to listOf("A.True", "B.False"),

    )
    val lesson2Answers: List<String> = listOf("B.Verbose", "A.True", "A.True", "A.True", "B.False", "A.True")
}