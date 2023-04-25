package com.powersoft.miuexamprep.db.seeders

object AndroidQuestions {
    val lesson2: Map<String, List<String>> = mapOf(
        "Which of the following is not a benefit of Kotlin ?" to listOf(
            "Expressive and concise", "Verbose", "Safer Code"
        ),
        "The keyword, val, is used for immutable variables" to listOf("True", "False"),
        "The keyword, when, is the replacement of switch in other languages" to listOf("True", "False"),
        "'for (i in 1..5) print(i)' is valid statement " to listOf("True", "False"),
        "In Kotlin, variables can be null by default" to listOf("True", "False"),
        "Allow null-pointer exceptions using the !! operator" to listOf("True", "False"),

    )
    val lesson2Answers: List<String> = listOf("Verbose", "True", "True", "True", "False", "True")
}