package com.agladkov.pddtest.di.modules

import com.agladkov.pddtest.data.themes.ThemeRemoteDataSource
import com.agladkov.pddtest.data.themes.ThemesLocalDataSource
import com.agladkov.pddtest.data.themes.ThemesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideThemesRepository(
        localDataSource: ThemesLocalDataSource,
        remoteDataSource: ThemeRemoteDataSource
    ): ThemesRepository {
        return ThemesRepository(localDataSource, remoteDataSource)
    }
}