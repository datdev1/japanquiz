package com.b21dccn216.japanesequizz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.b21dccn216.japanesequizz.network.dto.QuestionDTO
import com.b21dccn216.japanesequizz.ui.components.Question
import com.b21dccn216.japanesequizz.ui.screen.QuestionScreen
import com.b21dccn216.japanesequizz.ui.theme.JapaneseQuizzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JapaneseQuizzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuestionScreen(innerPadding)
                }
            }
        }
    }
}
