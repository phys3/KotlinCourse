package com.example.kotlincourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    BasicScreen()
        }
    }
}

@Composable
fun BasicScreen() {
    var step by remember { mutableIntStateOf(1) }
    var squeezeClicks by remember { mutableIntStateOf(0) }
    val text = when (step) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }

    val image = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val clicksToSqueeze = (2..4).random()

    val onClick = {
        if (step == 1) {
            step = 2
        } else if (step == 2) {
            println(clicksToSqueeze)
            squeezeClicks++
            if (squeezeClicks == clicksToSqueeze) {
                step = 3
                squeezeClicks = 0
            }
        } else if (step == 3) {
            step = 4
        } else {
            step = 1
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Text(text = "Lemonade", fontWeight = FontWeight(900), modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(16.dp), textAlign = TextAlign.Center)
        Column(modifier = Modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Button(onClick = onClick,
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC3ECD2),
                    contentColor = Color(0xFFC3ECD2),
                    disabledContainerColor = Color(0xFFC3ECD2),
                    disabledContentColor = Color(0xFFC3ECD2)
                ),
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Tree",
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.size(40.dp))
            Text(text = text)
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenPreview() {
        BasicScreen()
}