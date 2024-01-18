package com.aocheretyabyi.domain.model

data class WordDefinition(
    val word: String,
    val phonetic: String,
    val meanings: List<Meanings> = listOf()
)

data class Definitions(
    val definition: String = "",
    val example: String? = "",
)

data class Meanings(
    val partOfSpeech: String = "",
    val definitions: List<Definitions> = listOf()
)