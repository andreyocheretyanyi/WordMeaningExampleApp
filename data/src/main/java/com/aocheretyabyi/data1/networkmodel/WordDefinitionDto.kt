package com.aocheretyabyi.data1.networkmodel

import com.google.gson.annotations.SerializedName

typealias WordDefinitionResult = List<WordDefinitionDto>

data class WordDefinitionDto(
    @SerializedName("word") var word: String? = null,
    @SerializedName("phonetic") var phonetic: String? = null,
    @SerializedName("phonetics") var phonetics: ArrayList<Phonetics> = arrayListOf(),
    @SerializedName("meanings") var meanings: ArrayList<MeaningsDto> = arrayListOf()
)

data class Phonetics(
    @SerializedName("text") var text: String? = null,
    @SerializedName("audio") var audio: String? = null
)

data class DefinitionsDto(
    @SerializedName("definition") var definition: String? = null,
    @SerializedName("example") var example: String? = null,
)

data class MeaningsDto(
    @SerializedName("partOfSpeech") var partOfSpeech: String? = null,
    @SerializedName("definitions") var definitions: ArrayList<DefinitionsDto> = arrayListOf()
)