package com.aocheretyabyi.data1.util

import com.aocheretyabyi.data1.networkmodel.DefinitionsDto
import com.aocheretyabyi.data1.networkmodel.MeaningsDto
import com.aocheretyabyi.data1.networkmodel.WordDefinitionDto
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