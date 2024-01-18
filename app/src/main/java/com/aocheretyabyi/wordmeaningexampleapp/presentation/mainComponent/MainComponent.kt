package com.aocheretyabyi.wordmeaningexampleapp.presentation.mainComponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aocheretyabyi.wordmeaningexampleapp.presentation.defenitiondetails.DefinitionDetailsScreen
import com.aocheretyabyi.wordmeaningexampleapp.presentation.home.HomeScreen
import com.aocheretyabyi.wordmeaningexampleapp.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainComponent(navController: NavHostController, routerState: MutableState<String>) {
    Scaffold(modifier = Modifier, topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
            ),
            navigationIcon = {
                if (routerState.value.isNotEmpty() && routerState.value != Screen.HomeScreen.route) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            },
            title = {
                Text("Top app bar example")
            }
        )
    }) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screen.HomeScreen.route
        ) {
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
            composable(
                route = Screen.DefinitionDetailsScreen.createWithPath("?word={word}").route, arguments = listOf(
                    navArgument(
                        name = "word"
                    ) {
                        type = NavType.StringType
                        defaultValue = ""
                    })
            ) {
                val word = it.arguments?.getString("word") ?: ""
                DefinitionDetailsScreen(word = word)
            }
        }
    }

}