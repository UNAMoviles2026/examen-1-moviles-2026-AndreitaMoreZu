package com.movies.examenmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.movies.examenmovies.navigation.AppNavHost
import com.movies.examenmovies.ui.theme.GreenBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenMoviesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GreenBackground
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun ExamenMoviesTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = com.movies.examenmovies.ui.theme.Typography,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExamenMoviesTheme {
        AppNavHost()
    }
}