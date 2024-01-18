package com.aocheretyabyi.wordmeaningexampleapp.presentation.defenitiondetails

sealed class DefinitionDetailsEvent {
    data class OnScreenLoaded(val word: String) : DefinitionDetailsEvent()
}