package com.b21dccn216.japanesequizz.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.b21dccn216.japanesequizz.data.datasource.remote.dto.QuestionDTO
import com.b21dccn216.japanesequizz.ui.components.Question

@Composable
fun QuestionScreen(
    innerPadding: PaddingValues
) {
    val question = QuestionDTO(
        id = 0,
        word = "猫",
        kanji = "ねこ",
        option = listOf("Dog", "Cat", "Bird", "Fish"),
        answer = 1
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Question(question = question)
    }
}