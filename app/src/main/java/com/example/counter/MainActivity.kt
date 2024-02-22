package com.example.counter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App( modifier: Modifier = Modifier){


    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    val buttonModifier = Modifier
        .width(150.dp)
        .height(60.dp)

    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        AppText(text = counter.toString())

        Button(onClick = { counter++ }, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = buttonModifier) {
            Text(text = "Press me +1")
        }

        Spacer(modifier = modifier.height(15.dp))

        Button(onClick = { counter-- }, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = buttonModifier) {
            Text(text = "Press me -1")
        }
    }

}

@Composable
fun AppText(text: String){

    Text(
        text = text,
        color = Color.Red,
        fontSize = 100.sp

    )
    
    Spacer(modifier = Modifier.height(15.dp))



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        App()
    }
}