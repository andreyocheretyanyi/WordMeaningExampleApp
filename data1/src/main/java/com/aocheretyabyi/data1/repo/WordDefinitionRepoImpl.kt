package com.aocheretyabyi.data1.repo

import com.aocheretyabyi.data1.network.Api
import com.aocheretyabyi.data1.util.toDomain
import com.aocheretyabyi.data1.cache.SimpleLocalCache
import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import com.aocheretyabyi.domain.model.WordDefinition
import javax.inject.Inject

class WordDefinitionRepoImpl @Inject constructor(
    private val api: Api,
    private val cache: SimpleLocalCache
) : WordDefinitionRepo {

    override suspend fun getWordDefinition(word: String): Result<WordDefinition> {
        val localValue = cache.getCache(word)
        if (localValue != null) {
            return Result.success(localValue.toDomain())
        }
        return try {
            val response = api.getWordDefinition(word)
            if (response.isSuccessful) {
                val dto = response.body()!![0]
                cache.saveCache(word, dto)
                Result.success(dto.toDomain())
            } else {
                Result.failure(Exception("${response.message()} Code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}