package com.agladkov.pddtest.common.views

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.agladkov.pddtest.R

class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val headerTitleView = itemView.findViewById<AppCompatTextView>(R.id.headerTitleView)

    fun bind(model: HeaderCellModel) {
        headerTitleView.text = model.title
    }
}