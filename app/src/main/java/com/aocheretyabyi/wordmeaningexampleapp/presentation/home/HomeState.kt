package com.aocheretyabyi.wordmeaningexampleapp.presentation.home

import com.aocheretyabyi.domain.model.WordDefinition

sealed class HomeState {

    data object EmptyState : HomeState()
    data class HomeStateSuccess(
        val wordDefinition: WordDefinition, val isSearchButtonActive: Boolean = false
    ) : HomeState()

    data class Error(val message: String) : HomeState()
}

