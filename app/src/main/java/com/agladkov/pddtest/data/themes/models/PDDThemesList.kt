package com.agladkov.pddtest.data.themes.models

data class PDDThemesList(val status: String, val themes: List<TestTheme>)

data class TestTheme(val id: Int, val title: String, val image: String)
