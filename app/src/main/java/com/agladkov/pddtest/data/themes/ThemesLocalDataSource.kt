package com.agladkov.pddtest.data.themes

import com.agladkov.pddtest.data.themes.models.PDDThemesList
import io.reactivex.Completable
import io.reactivex.Single

interface ThemesLocalDataSource {
    fun saveRemote(data: PDDThemesList)
    fun fetchLocal(): PDDThemesList
}