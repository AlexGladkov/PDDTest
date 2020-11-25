package com.agladkov.pddtest.screens

import android.app.Application
import com.agladkov.pddtest.di.AppComponent
import com.agladkov.pddtest.di.DaggerAppComponent

class PddTestApplication: Application() {

//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>
//
//    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}