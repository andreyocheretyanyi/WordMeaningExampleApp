package com.aocheretyabyi.data.util

import com.aocheretyabyi.data.networkmodel.DefinitionsDto
import com.aocheretyabyi.data.networkmodel.MeaningsDto
import com.aocheretyabyi.data.networkmodel.WordDefinitionDto
import com.aocheretyabyi.domain.model.Definitions
import com.aocheretyabyi.domain.model.Meanings
import com.aocheretyabyi.domain.model.WordDefinition

fun WordDefinitionDto.toDomain(): WordDefinition {
    val phonetic = this.phonetic ?: phonetics.find { it.text != null }?.text ?: ""
    return WordDefinition(word ?: "", phonetic, meanings.map { it.toDomain() })
}

fun MeaningsDto.toDomain(): Meanings {
    return Meanings(partOfSpeech ?: "", definitions.map { it.toDomain() })
}

fun DefinitionsDto.toDomain(): Definitions {
    return Definitions(definition ?: "", example ?: "")
}