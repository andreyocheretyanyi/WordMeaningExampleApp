package com.aocheretyabyi.wordmeaningexampleapp.presentation.defenitiondetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DefinitionDetailsScreen(
    definitionDetailsViewModel: DefinitionDetailsViewModel = hiltViewModel(),
    word: String
) {
    LaunchedEffect(key1 = Unit) {
        definitionDetailsViewModel.onEvent(DefinitionDetailsEvent.OnScreenLoaded(word))
    }
    val data = definitionDetailsViewModel.data.value
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = Dp(16f)),
        content = {
            val spaceModifier = Modifier.padding(vertical = Dp(3f))
            items(items = data, itemContent = { meanings ->
                Text(modifier = spaceModifier, fontWeight = FontWeight.Bold, text = meanings.partOfSpeech.uppercase())
                meanings.definitions.forEach { definitions ->
                    Text(modifier = spaceModifier, fontWeight = FontWeight.SemiBold, text = definitions.definition)
                    definitions.example?.let {
                        Text(modifier = spaceModifier, text = it)
                    }
                }
            })

        })
}
