package com.agladkov.pddtest.screens.test.models

import com.agladkov.pddtest.common.views.BaseCellModel

data class TestCellModel(val id: Int, val name: String, val icon: String, val isChecked: Boolean):
    BaseCellModel {

    override fun getItemViewType(): Int {
        return 0
    }
}