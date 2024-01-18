package com.aocheretyabyi.domain.usecase

import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import javax.inject.Inject

class GetDetailedDefinitionsUseCase @Inject constructor(private val wordDefinitionRepo: WordDefinitionRepo) {
    suspend fun getDetailedDefinitions(word: String) =
        try {
            Result.success(wordDefinitionRepo.getWordDefinition(word).getOrThrow().meanings)
        } catch (e: Exception) {
            Result.failure(e)
        }
}