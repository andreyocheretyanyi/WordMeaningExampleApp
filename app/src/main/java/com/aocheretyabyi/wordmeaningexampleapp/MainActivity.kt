package com.aocheretyabyi.wordmeaningexampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.aocheretyabyi.domain.usecase.GetWordDefinitionUseCase
import com.aocheretyabyi.wordmeaningexampleapp.ui.theme.WordMeaningExampleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var useCase: GetWordDefinitionUseCase
    private var stateFlow: MutableStateFlow<String> = MutableStateFlow("Android")
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordMeaningExampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val text = stateFlow.collectAsState()
                    Greeting(text.value)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        job?.cancel()
        job = lifecycleScope.launch {
            useCase.getWordDefinitionResult("Hello").fold(onSuccess = {
                stateFlow.emit("1")
            }, onFailure = {
                stateFlow.emit("2")
            })
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WordMeaningExampleAppTheme {
        Greeting("Android")
    }
}