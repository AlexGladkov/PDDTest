package com.agladkov.pddtest.di

import com.agladkov.pddtest.di.modules.RemoteModule
import com.agladkov.pddtest.di.modules.RepositoryModule
import com.agladkov.pddtest.di.modules.ViewModelModule
import com.agladkov.pddtest.screens.test.TestsFragment
import com.agladkov.pddtest.screens.test.TestsModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RemoteModule::class,
        TestsModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(fragment: TestsFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}