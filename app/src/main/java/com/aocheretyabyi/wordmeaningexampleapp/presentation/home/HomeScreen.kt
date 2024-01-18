@file:OptIn(ExperimentalMaterial3Api::class)

package com.aocheretyabyi.wordmeaningexampleapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aocheretyabyi.wordmeaningexampleapp.R
import com.aocheretyabyi.wordmeaningexampleapp.presentation.util.Screen


@Composable
fun HomeScreen(
    navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()
) {
    val state = homeViewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dp(16f))
    ) {
        Text(text = stringResource(R.string.enter_one_en_word))
        Row(modifier = Modifier.padding(vertical = Dp(10f))) {
            var text by rememberSaveable {
                mutableStateOf("")
            }
            TextField(modifier = Modifier
                .weight(1f)
                .padding(end = Dp(3f)),
                value = text,
                onValueChange = { text = it })
            Button(modifier = Modifier
                .weight(1f)
                .padding(start = Dp(3f)),
                onClick = { homeViewModel.onEvent(HomeEvent.RetrieveDefinition(text)) }) {
                Text(text = stringResource(R.string.get_definition))
            }
        }
        if (state is HomeState.HomeStateSuccess) {
            Row(modifier = Modifier.padding(vertical = Dp(10f))) {
                Text(modifier = Modifier.weight(1f), text = stringResource(R.string.phonetic))
                Text(modifier = Modifier.weight(1f), text = state.wordDefinition.phonetic)
            }
            Button(onClick = {
                navController.navigate(
                    Screen.DefinitionDetailsScreen.createWithPath(
                        "?word=${state.wordDefinition.word}"
                    ).route
                )
            }) {
                Text(text = stringResource(R.string.see_detail_definitions))
            }
        } else if (state is HomeState.Error) {
            Text(
                modifier = Modifier.padding(vertical = Dp(10f)),
                text = stringResource(R.string.definition_not_found_or_there_is_an_error)
            )
        }
    }
}