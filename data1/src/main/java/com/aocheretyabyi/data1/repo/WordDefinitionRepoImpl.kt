package com.aocheretyabyi.data1.repo

import com.aocheretyabyi.data1.network.Api
import com.aocheretyabyi.data.util.toDomain
import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import com.aocheretyabyi.domain.model.WordDefinition
import javax.inject.Inject

class WordDefinitionRepoImpl @Inject constructor(private val api: Api) : WordDefinitionRepo {

    override suspend fun getWordDefinition(word: String): Result<WordDefinition> {
        return try {
            val response = api.getWordDefinition(word)
            if (response.isSuccessful) {
                Result.success(response.body()!![0].toDomain())
            } else {
                Result.failure(Exception("${response.message()} Code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}