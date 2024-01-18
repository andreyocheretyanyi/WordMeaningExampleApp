package com.aocheretyabyi.wordmeaningexampleapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.aocheretyabyi.wordmeaningexampleapp.presentation.mainComponent.MainComponent
import com.aocheretyabyi.wordmeaningexampleapp.presentation.util.Screen
import com.aocheretyabyi.wordmeaningexampleapp.ui.theme.WordMeaningExampleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val routerState = mutableStateOf(Screen.HomeScreen.route)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordMeaningExampleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.Transparent
                ) {
                    val navController = rememberNavController()
                    navController.addOnDestinationChangedListener { _, destination, _ ->
                        routerState.value = destination.route ?: ""
                    }
                    MainComponent(navController = navController, routerState = routerState)
                }
            }
        }
    }

}
