package com.agladkov.pddtest.di.modules

import androidx.lifecycle.ViewModelProvider
import com.agladkov.pddtest.helpers.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}