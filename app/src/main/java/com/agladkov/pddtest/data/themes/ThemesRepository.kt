package com.agladkov.pddtest.data.themes

import com.agladkov.pddtest.data.themes.models.PDDThemesList
import io.reactivex.Single
import javax.inject.Inject

class ThemesRepository @Inject constructor(
    private val localDataSource: ThemesLocalDataSource,
    private val remoteDataSource: ThemeRemoteDataSource
) {

    fun fetchThemes(): Single<PDDThemesList> {
        return remoteDataSource.fetchRemote().flatMap {
            localDataSource.saveRemote(it)
            Single.just(it)
        }
    }
}