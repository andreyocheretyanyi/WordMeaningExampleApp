package com.aocheretyabyi.domain.usecase

import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import com.aocheretyabyi.domain.model.WordDefinition
import javax.inject.Inject

class GetWordDefinitionUseCase @Inject constructor(private val wordDefinitionRepo: WordDefinitionRepo) {
    suspend fun getWordDefinitionResult(word: String): Result<WordDefinition> =
        wordDefinitionRepo.getWordDefinition(word)
}