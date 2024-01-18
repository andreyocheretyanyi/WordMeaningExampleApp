package com.aocheretyabyi.data.network

import com.aocheretyabyi.data.networkmodel.WordDefinitionResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val GET_WORD_DEFINITION_URL = "/api/v2/entries/en/{word}"

interface Api {
    @GET(GET_WORD_DEFINITION_URL)
    suspend fun getWordDefinition(@Path("word") word: String): Response<WordDefinitionResult>
}