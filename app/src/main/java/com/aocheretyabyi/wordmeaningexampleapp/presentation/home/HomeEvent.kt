package com.aocheretyabyi.wordmeaningexampleapp.presentation.home

sealed class HomeEvent {
    data class RetrieveDefinition(val word: String): HomeEvent()
}
