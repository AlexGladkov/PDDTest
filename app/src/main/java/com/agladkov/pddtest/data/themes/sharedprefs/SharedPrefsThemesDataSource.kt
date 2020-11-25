package com.agladkov.pddtest.data.themes.sharedprefs

import com.agladkov.pddtest.data.themes.ThemesLocalDataSource
import com.agladkov.pddtest.data.themes.models.PDDThemesList
import javax.inject.Inject

class SharedPrefsThemesDataSource @Inject constructor() : ThemesLocalDataSource {

    override fun saveRemote(data: PDDThemesList) {
        // Stub
    }

    override fun fetchLocal(): PDDThemesList {
        return PDDThemesList(
            status = "ok",
            themes = emptyList()
        )
    }

}