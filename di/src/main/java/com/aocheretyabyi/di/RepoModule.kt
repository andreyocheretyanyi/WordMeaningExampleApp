package com.aocheretyabyi.di

import com.aocheretyabyi.data.repo.WordDefinitionRepoImpl
import com.aocheretyabyi.domain.abstractions.repo.WordDefinitionRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun bindWordDefinitionRepo(wordDefinitionRepoImpl: WordDefinitionRepoImpl): WordDefinitionRepo
}