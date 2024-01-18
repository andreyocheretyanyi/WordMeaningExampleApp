package com.aocheretyabyi.domain.abstractions.repo

import com.aocheretyabyi.domain.model.WordDefinition

interface WordDefinitionRepo {
    suspend fun getWordDefinition(word: String): Result<WordDefinition>
}