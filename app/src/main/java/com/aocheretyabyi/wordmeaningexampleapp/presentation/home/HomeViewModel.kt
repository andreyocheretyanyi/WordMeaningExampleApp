package com.aocheretyabyi.wordmeaningexampleapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aocheretyabyi.domain.usecase.GetWordDefinitionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetWordDefinitionUseCase) :
    ViewModel() {
    private val _state = mutableStateOf<HomeState>(HomeState.EmptyState)
    val state: State<HomeState> = _state

    private var getDefinitionJob: Job? = null

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.RetrieveDefinition -> {
                getDefinition(event.word)
            }
        }
    }

    private fun getDefinition(word: String) {
        getDefinitionJob?.cancel()
        getDefinitionJob = viewModelScope.launch {
            useCase.getWordDefinitionResult(word).fold(onSuccess = { wordDefinition ->
                _state.value = HomeState.HomeStateSuccess(wordDefinition, true)
            }, onFailure = { error -> _state.value = HomeState.Error("Some error") })
        }
    }
}