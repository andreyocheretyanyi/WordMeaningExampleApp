package com.aocheretyabyi.wordmeaningexampleapp.presentation.defenitiondetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aocheretyabyi.domain.model.Meanings
import com.aocheretyabyi.domain.usecase.GetDetailedDefinitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefinitionDetailsViewModel @Inject constructor(private val getDetailedDefinitionsUseCase: GetDetailedDefinitionsUseCase) :
    ViewModel() {
    private val _data = mutableStateOf(listOf<Meanings>())
    val data: State<List<Meanings>> = _data

    private fun getDetailedDefinitions(word: String) {
        viewModelScope.launch {
            getDetailedDefinitionsUseCase.getDetailedDefinitions(word).fold(onSuccess = {
                _data.value = it
            }, onFailure = {
                _data.value = listOf()
            })
        }
    }

    fun onEvent(definitionDetailsEvent: DefinitionDetailsEvent) {
        when (definitionDetailsEvent) {
            is DefinitionDetailsEvent.OnScreenLoaded -> {
                getDetailedDefinitions(definitionDetailsEvent.word)
            }
        }
    }
}