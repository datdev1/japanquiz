package com.b21dccn216.japanesequizz.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b21dccn216.japanesequizz.data.datasource.remote.dto.QuestionDTO

@Composable
fun Question(
    question: QuestionDTO
){
    Column(){
        QuestionTitle(word = question.word, kanji = question.kanji)
        val context = LocalContext.current
        QuestionOptions(options = question.option){
            val check = question.answer == it
            Toast.makeText(context, if(check) "Correct" else "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

}

@Composable
fun QuestionOptions(
    options: List<String>,
    onclickOption: (Int) -> Unit
){
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        options.forEachIndexed{ index, option ->
            item {
                OptionQuiz(
                    word = option,
                    onClick = { onclickOption(index) })
            }
        }
    }
}


@Composable
fun QuestionTitle(word: String, kanji: String){
    var isShowKanji by remember { mutableStateOf(false) }
    QuestionQuiz(
        word = if(isShowKanji) kanji else word,
        onClick = { isShowKanji = !isShowKanji })
}


@Composable
fun OptionQuiz(word: String, onClick: () -> Unit){
    TextQuiz(
        word = word,
        onClick = onClick,
        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Light)
    )
}

@Composable
fun QuestionQuiz(word: String, onClick: () -> Unit){
    TextQuiz(
        word = word,
        onClick = onClick,
        textStyle = TextStyle(
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
    ))
}

@Composable
fun TextQuiz(
    word: String,
    onClick: () -> Unit,
    textStyle: TextStyle
){
    Surface(
        shape = RoundedCornerShape(25),
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = word,
                style = textStyle,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionPreview(){
    val q = QuestionDTO(id = 0,
        word = "ねこ",
        kanji = "猫",
        option = listOf("Dog",
            "Cat",
            "Bird",
            "Fish"),
        answer = 0)
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Question(question = q)
    }
}