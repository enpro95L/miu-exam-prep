package com.powersoft.miuexamprep.db.seeders

object AndroidQuestions {
    private val lesson2: Map<String, List<String>> = mapOf(
        "Which of the following is not a benefit of Kotlin" to listOf(
            "A. Expressive and concise", "B.Verbose", "C. Safer Code"
        ),
        "The keyword, val, is used for immutable variables" to listOf("A.True", "B.False"),
        "The keyword, when, is the replacement of switch in other languages" to listOf("A.True", "B.False"),
        "'for (i in 1..5) print(i)' is valid statement " to listOf("A.True", "B.False"),
        "In Kotlin, variables can be null by default" to listOf("A.True", "B.False"),
        "Allow null-pointer exceptions using the !! operator" to listOf("A.True", "B.False"),
        "In Kotlin, we test for null using the elvis?" to listOf("A.?:", "B.!", "isNUll()"),
        "In Kotlin, all data types are of the primitive type" to listOf("A. True", "B.False"),
        "Which of the following is the safe call operator in Kotlin" to listOf("A.?", "B.!!", "C.?:"),
        "Which of the following will throw an exception if null?" to listOf("A.?", "B.!!", "C.?:")
    )
    private val lesson2Answers: List<String> = listOf("B.Verbose", "A.True", "A.True", "A.True", "B.False", "A.True", "A.?:", "B.False", "A.?", "B.!!")


    private val lesson3: Map<String, List<String>> = mapOf(
        "Handles user input and creates a window on the screen to display your user interface" to listOf<String>("A.Activity", "B.Resources", "C.Graddle"),
        "They are additional files that your code uses, such as layout files, images, audio files, themes, colors, and more." to listOf<String>("A.Activity", "B.Resources", "C.Graddle"),
        "_____________ - declares essential information for your app" to listOf<String>("A.app", "B.AndroidManifest.xml", "C.Graddle"),
        "________________ - controls how your application builds, tests, and deploys itself." to listOf<String>("A.app", "B.AndroidManifest.xml", "C.Graddle"),
        "________________ - are they interface building blocks." to listOf<String>("A.View", "B.AndroidManifest.xml", "C.Graddle"),
        "Use a ______________________ if you have only one child View." to listOf<String>("A.LinearLayout", "B.ConstraintLayout", "C.FrameLayout"),
        "Use a ______________________ to display views in a row or column." to listOf<String>("A.LinearLayout", "B.ConstraintLayout", "C.FrameLayout"),
        "Use a ______________________ for more complex layouts." to listOf<String>("A.LinearLayout", "B.ConstraintLayout", "C.FrameLayout")
    )
    private val lesson3Answers: List<String> = listOf("A.Activity", "B.Resources", "B.AndroidManifest.xml", "C.Graddle", "A.View", "C.FrameLayout", "A.LinearLayout", "B.ConstraintLayout")

    val questions: Map<Int, Map<String, List<String>>> = mapOf(
        2 to lesson2,
        3 to lesson3
    )
    val anwers: Map<Int, List<String>> = mapOf(
        2 to lesson2Answers,
        3 to lesson3Answers
    )
}