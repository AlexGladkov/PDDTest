package com.agladkov.pddtest.data.themes.retrofit

import com.agladkov.pddtest.data.themes.models.PDDThemesList
import io.reactivex.Single
import retrofit2.http.*

interface ThemesApi {

    // Observable - onNext, onError, onComplete

    // Flowable - onNext, onError, onComplete, BackPressureStrategy

    // Single - onSuccess, onError

    // Maybe - onSuccess, onError, onComplete

    // Completable - onComplete, onError

    @GET("/pddthemes")
    fun getThemes(): Single<PDDThemesList>
}