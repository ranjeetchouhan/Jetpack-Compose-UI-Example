package com.ranjeet.jetpackcomposeui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope.gravity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ranjeet.jetpackcomposeui.ui.JetpackComposeUITheme
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    Column() {
                        Greeting("Android")
                        Divider(color = Color.White)
                        Counter(this@MainActivity)
                    }
                }
            }
        }



    }


}

@Composable
fun Greeting(name: String) {
    val time = Date()
    Surface() {
        Text(text = "Today's Date : $time!",modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun Counter(context: Context) {



    Column(modifier = Modifier.gravity(Alignment.CenterHorizontally)) {

        Button(onClick = {
            Toast.makeText(context,"You clicked button",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Click Here")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeUITheme {
        Column {
            Greeting("Android")
            Divider(color = Color.White)
            Counter(context = MainActivity::class.java as Context)
        }
    }
}