package com.example.kotlincourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincourse.ui.theme.KotlinCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Red
                ) {
                    BasicScreen()
                }
            }
        }
    }
}

@Composable
fun Quadrant(text1: String, text2: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = bgColor)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = text1,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(0.dp, 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun BasicScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Quadrant(
                text1 = "Text composable",
                text2 = "Displays text and follows the recommended Material Design guidelines.",
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                text1 = "Text composable",
                text2 = "Displays text and follows the recommended Material Design guidelines.",
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .background(Color.White)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Quadrant(
                text1 = "Text composable",
                text2 = "Displays text and follows the recommended Material Design guidelines.",
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                text1 = "Text composable",
                text2 = "Displays text and follows the recommended Material Design guidelines.",
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenPreview() {
    KotlinCourseTheme {
        BasicScreen()
    }
}