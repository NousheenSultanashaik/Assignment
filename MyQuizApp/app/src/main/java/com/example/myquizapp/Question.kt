package com.example.myquizapp

data class Question(
    val id : Int,
    val question : String,
    val optionone : String,
    val optiontwo : String,
    val optionthree : String,
    val optionfour : String,
    val correctAnswer : Int
)
