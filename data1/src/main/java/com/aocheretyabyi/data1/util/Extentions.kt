package com.aocheretyabyi.data.util

import com.aocheretyabyi.data1.networkmodel.WordDefinitionDto
import com.aocheretyabyi.domain.model.WordDefinition

fun WordDefinitionDto.toDomain(): WordDefinition {
    return WordDefinition(1)
}