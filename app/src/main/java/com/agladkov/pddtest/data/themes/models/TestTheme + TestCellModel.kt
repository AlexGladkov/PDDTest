package com.agladkov.pddtest.data.themes.models

import com.agladkov.pddtest.screens.test.models.TestCellModel

fun TestTheme.mapToCellModel(): TestCellModel {
    return TestCellModel(
        id = this.id,
        name = this.title,
        icon = this.image,
        isChecked = false
    )
}