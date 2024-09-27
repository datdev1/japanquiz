package com.b21dccn216.japanesequizz.model

class Question(
    val id: Int,
    val word: Pair<String, String>,
    val option: List<String>,
    val answer: Int
){
    fun checkAnswer(answer: Int): Boolean{
        return this.answer == answer
    }
    
}