package com.aocheretyabyi.data1.networkmodel

import com.google.gson.annotations.SerializedName

typealias WordDefinitionResult = List<WordDefinitionDto>

data class WordDefinitionDto(
    @SerializedName("word") var word: String? = null,
    @SerializedName("phonetic") var phonetic: String? = null,
    @SerializedName("phonetics") var phonetics: ArrayList<Phonetics> = arrayListOf(),
    @SerializedName("origin") var origin: String? = null,
    @SerializedName("meanings") var meanings: ArrayList<Meanings> = arrayListOf()
)

data class Phonetics(
    @SerializedName("text") var text: String? = null,
    @SerializedName("audio") var audio: String? = null
)

data class Definitions(
    @SerializedName("definition") var definition: String? = null,
    @SerializedName("example") var example: String? = null,
    @SerializedName("synonyms") var synonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("antonyms") var antonyms: ArrayList<String> = arrayListOf()
)

data class Meanings(
    @SerializedName("partOfSpeech") var partOfSpeech: String? = null,
    @SerializedName("definitions") var definitions: ArrayList<Definitions> = arrayListOf()
)