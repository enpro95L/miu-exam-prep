package com.powersoft.miuexamprep.db.seeders

object AndroidQuestions {
    val lesson2: Map<String, List<String>> = mapOf(
        "Which of the following is not a benefit of Kotlin" to listOf(
            "Expressive and concise", "Verbose", "Safer Code"
        ),
        "The keyword, val, is used for immutable variables" to listOf("True", "False"),
        "The keyword, when, is the replacement of switch in other languages" to listOf("True", "False"),
        "'for (i in 1..5) print(i)' is valid statement " to listOf("True", "False"),
        "In Kotlin, variables can be null by default" to listOf("True", "False"),
        "Allow null-pointer exceptions using the !! operator" to listOf("True", "False"),
        "In Kotlin, we test for null using the elvis?" to listOf("?:", "!", "isNUll()"),
        "In Kotlin, all data types are of the primitive type" to listOf("True", "False"),
        "Which of the following is the safe call operator in Kotlin" to listOf("?", "!!", "?:"),
        "Which of the following will throw an exception if null?" to listOf("?", "!!", "?:")
    )

    val lesson2Answers: List<String> = listOf("Verbose", "True", "True", "True", "False", "True", "?:", "False", "?", "!!")

    val lesson3: Map<String, List<String>> = mapOf(
        "Handles user input and creates a window on the screen to display your user interface" to listOf<String>("Activity", "Resources", "Graddle"),
        "They are additional files that your code uses, such as layout files, images, audio files, themes, colors, and more." to listOf<String>("Activity", "Resources", "Graddle"),
        "_____________ - declares essential information for your app" to listOf<String>("app", "AndroidManifest.xml", "Graddle"),
        "________________ - controls how your application builds, tests, and deploys itself." to listOf<String>("app", "AndroidManifest.xml", "Graddle"),
        "________________ - are they interface building blocks." to listOf<String>("View", "AndroidManifest.xml", "Graddle"),
        "Use a ______________________ if you have only one child View." to listOf<String>("LinearLayout", "ConstraintLayout", "FrameLayout"),
        "Use a ______________________ to display views in a row or column." to listOf<String>("LinearLayout", "ConstraintLayout", "FrameLayout"),
        "Use a ______________________ for more complex layouts." to listOf<String>("LinearLayout", "ConstraintLayout", "FrameLayout")
    )

    val lesson3Answers: List<String> = listOf("Activity", "Resources", "AndroidManifest.xml", "Graddle", "View", "FrameLayout", "LinearLayout", "ConstraintLayout")


    val lesson5: Map<String, List<String>> = mapOf(
        "Which of the following standard algorithms is not Dynamic Programming based." to
                listOf<String>(
                    "Bellman–Ford Algorithm for single source shortest path",
                    "Floyd Warshall Algorithm for all pairs shortest paths",
                    "0-1 Knapsack problem",
                    "Prim's Minimum Spanning Tree"),
        "Which of the following is not true about comparison-based sorting algorithms?" to
                listOf<String>(
                    "The minimum possible time complexity of a comparison-based sorting algorithm is O(n(log(n)) for a random input array",
                    "Any comparison based sorting algorithm can be made stable by using position as a criteria when two elements are compared",
                    "Counting Sort is not a comparison based sorting algorithm",
                    "Heap Sort is not a comparison based sorting algorithm."),
        "Which of the following is not a backtracking algorithm?" to
                listOf<String>("Knight tour problem", "N queen problem", "Tower of hanoi", "M coloring problem"),
        "In a complete k-ary tree, every internal node has exactly k children. The number of leaves in such a tree with n internal nodes is:" to
                listOf<String>("nk", "(n – 1) k+ 1", "n( k – 1) + 1", "n( k – 1)"),
        "The following statement is valid. log(n!) = Ө(n log n)." to listOf<String>("True", "False")
    )

    val lesson5Answers: List<String> = listOf(
        "Prim's Minimum Spanning Tree",
        "Heap Sort is not a comparison based sorting algorithm.",
        "Tower of hanoi",
        "n( k – 1) + 1",
        "True")
}