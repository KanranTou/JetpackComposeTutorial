package com.example.jetpack_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_tutorial.ui.theme.Jetpack_compose_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_tutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialText(
                        title = stringResource(R.string.jetpack_compose_title_text),
                        about = stringResource(R.string.jetpack_compose_about_text),
                        tutorial = stringResource(R.string.jetpack_compose_tutorial_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialText(title: String, about: String, tutorial: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement =Arrangement.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = about,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        )
        Text(
            text = tutorial,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun TutorialImage(title: String, about: String, tutorial: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column (modifier){
        Image(
            painter = image,
            contentDescription = null,
        )
        TutorialText(
            title = title,
            about = about,
            tutorial = tutorial,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    Jetpack_compose_tutorialTheme {
        TutorialImage(
            title = stringResource(R.string.jetpack_compose_title_text),
            about = stringResource(R.string.jetpack_compose_about_text),
            tutorial = stringResource(R.string.jetpack_compose_tutorial_text)
        )
    }
}