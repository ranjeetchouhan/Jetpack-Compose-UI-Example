package com.ranjeet.jetpackcomposeui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ranjeet.jetpackcomposeui.ui.JetpackComposeUITheme
import com.ranjeet.jetpackcomposeui.ui.typography

class MainActivity : AppCompatActivity() {
    @ExperimentalLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           FirstPage(this)
        }

    }
}

@ExperimentalLayout
@Composable
fun FirstPage(context: Context) {
    val image = imageResource(R.drawable.header)
    JetpackComposeUITheme() {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {

            val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))

            Image(image, modifier = imageModifier,
                    contentScale = ContentScale.Crop)

            Spacer(Modifier.preferredHeight(16.dp))
                Text(text = "Welcome to Compose UI",
                        style = typography.h6)

                Text(text = "Jetpack Compose UI is just release in alpha version." +
                        "Compose UI is a declarative UI just like Flutter. Easy to use." +
                        "You can check more this repository and other tutorial for Compose UI." +
                        "This is awesome library. Try it. you will love this.",
                        style = typography.body1,textAlign = TextAlign.Justify)


            Spacer(Modifier.preferredHeight(8.dp))
            Divider(color = Color.Gray,thickness = 1.dp)
            Spacer(Modifier.preferredHeight(8.dp))
            Text(text = "Check out this repository",
            style = typography.body2)
            val url = "https://github.com/im-ranu/Jetpack-Compose-UI-Example"

            Text(text = url, modifier = Modifier.clickable(onClick = {
                Toast.makeText(context,"Thanks for clicking",Toast.LENGTH_SHORT).show()
            }), style = typography.body2)
            Spacer(Modifier.preferredHeight(48.dp))


            Button(elevation = 4.dp,
                    onClick = {
                Toast.makeText(context,"Thank you for clicking",Toast.LENGTH_SHORT).show()
            },modifier = Modifier.gravity(Alignment.CenterHorizontally)) {
                Text(text = "Click Here")
            }
        }

    }
}




@ExperimentalLayout
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstPage(MainActivity())
}