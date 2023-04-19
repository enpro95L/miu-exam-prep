package com.powersoft.miuexamprep.model

data class MCQ(
    var question: String,
    var optionList: List<String>,
    var correctAnswer: String
) : java.io.Serializable


/* USAGE
* MCQ("Fish is a land animal", listOf("True", "False"), "False")
* MCQ("Which is not a country?", listOf("Ghana", "Mongolia", "Nepal", "King"), "King")
* */