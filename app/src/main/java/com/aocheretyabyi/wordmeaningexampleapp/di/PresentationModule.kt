package com.aocheretyabyi.wordmeaningexampleapp.di

import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import com.aocheretyabyi.domain.usecase.GetDetailedDefinitionsUseCase
import com.aocheretyabyi.domain.usecase.GetWordDefinitionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {
    @Provides
    fun provideWordDefinitionUseCase(wordDefinitionRepo: WordDefinitionRepo): GetWordDefinitionUseCase =
        GetWordDefinitionUseCase(wordDefinitionRepo)

    @Provides
    fun provideDetailedDefinitionUseCase(wordDefinitionRepo: WordDefinitionRepo): GetDetailedDefinitionsUseCase =
        GetDetailedDefinitionsUseCase(wordDefinitionRepo)
}