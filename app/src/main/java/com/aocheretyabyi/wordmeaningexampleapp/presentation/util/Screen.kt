package com.aocheretyabyi.wordmeaningexampleapp.presentation.util

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home")
    data class DefinitionDetailsScreen(private val screenRoute: String) : Screen(screenRoute) {
        companion object {
            private const val defaultRoute = "definitionDetails"
            fun getDefault() = DefinitionDetailsScreen(defaultRoute)

            fun createWithPath(path: String) = DefinitionDetailsScreen("{$defaultRoute}$path")
        }
    }

}