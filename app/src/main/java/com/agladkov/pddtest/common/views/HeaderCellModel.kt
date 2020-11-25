package com.agladkov.pddtest.common.views

data class HeaderCellModel(val title: String): BaseCellModel {
    override fun getItemViewType(): Int {
        return 1
    }
}