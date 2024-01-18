package com.aocheretyabyi.data1.cache

import com.aocheretyabyi.data1.networkmodel.WordDefinitionDto

class SimpleLocalCache {
    private val cache: MutableMap<String, WordDefinitionDto> = mutableMapOf()

    fun getCache(word: String): WordDefinitionDto? = cache[word]

    fun saveCache(word: String, wordDefinitionDto: WordDefinitionDto) {
        if (cache.containsKey(word)) {
            cache.remove(word)
        }
        cache[word] = wordDefinitionDto
    }
}