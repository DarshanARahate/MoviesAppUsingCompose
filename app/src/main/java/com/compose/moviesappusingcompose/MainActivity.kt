package com.compose.moviesappusingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.compose.moviesappusingcompose.navigation.MovieNavigation
import com.compose.moviesappusingcompose.ui.theme.MoviesAppUsingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MoviesAppUsingComposeTheme {
        content()
    }
}
