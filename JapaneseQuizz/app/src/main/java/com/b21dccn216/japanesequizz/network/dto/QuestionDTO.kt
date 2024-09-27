package com.b21dccn216.japanesequizz.network.dto

data class QuestionDTO(
    val id: Int,
    val word: String,
    val kanji: String,
    val option: List<String>,
    val answer: Int,
)