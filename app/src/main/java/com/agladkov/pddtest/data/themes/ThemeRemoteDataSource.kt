package com.agladkov.pddtest.data.themes

import com.agladkov.pddtest.data.themes.models.PDDThemesList
import io.reactivex.Single

interface ThemeRemoteDataSource {
    fun fetchRemote(): Single<PDDThemesList>
}