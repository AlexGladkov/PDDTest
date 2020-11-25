package com.agladkov.pddtest.screens.test

import androidx.lifecycle.ViewModel
import com.agladkov.pddtest.helpers.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TestsModule {

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    internal abstract fun testViewModel(viewModel: TestViewModel): ViewModel
}