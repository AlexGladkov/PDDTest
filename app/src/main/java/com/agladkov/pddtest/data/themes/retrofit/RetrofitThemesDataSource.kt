package com.agladkov.pddtest.data.themes.retrofit

import com.agladkov.pddtest.data.themes.ThemeRemoteDataSource
import com.agladkov.pddtest.data.themes.models.PDDThemesList
import io.reactivex.Single
import javax.inject.Inject

class RetrofitThemesDataSource @Inject constructor(val themesApi: ThemesApi) :
    ThemeRemoteDataSource {

    override fun fetchRemote(): Single<PDDThemesList> {
        return themesApi.getThemes()
    }
}