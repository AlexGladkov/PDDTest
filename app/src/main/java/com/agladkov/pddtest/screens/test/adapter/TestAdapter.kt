package com.agladkov.pddtest.screens.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.agladkov.pddtest.R
import com.agladkov.pddtest.common.views.BaseCellModel
import com.agladkov.pddtest.common.views.HeaderCellModel
import com.agladkov.pddtest.common.views.HeaderViewHolder
import com.agladkov.pddtest.screens.test.models.TestCellModel

interface TestAdapterClick {
    fun onRuleCheckedChanged(isChecked: Boolean, model: TestCellModel)
}

class TestAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data: MutableList<BaseCellModel> = ArrayList()
    private var testAdapterClick: TestAdapterClick? = null

    fun setData(data: List<BaseCellModel>) {
        this.data.clear()
        this.data.addAll(data)

        notifyDataSetChanged()
    }

    fun setTestAdapterClick(testAdapterClick: TestAdapterClick) {
        this.testAdapterClick = testAdapterClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            1 -> HeaderViewHolder(layoutInflater.inflate(R.layout.cell_header, parent, false))
            else -> TestViewHolder(testAdapterClick, layoutInflater.inflate(R.layout.cell_test, parent, false))
        }
    }

    override fun getItemCount(): Int = data.count()

    override fun getItemViewType(position: Int): Int {
        return data[position].getItemViewType()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TestViewHolder -> holder.bind(data[position] as? TestCellModel)
            is HeaderViewHolder -> holder.bind(data[position] as HeaderCellModel)
        }
    }

    class TestViewHolder(private val testAdapterClick: TestAdapterClick?, itemView: View): RecyclerView.ViewHolder(itemView) {
        private val iconView: AppCompatImageView = itemView.findViewById(R.id.testIconView)
        private val titleView: AppCompatTextView = itemView.findViewById(R.id.testTitleView)
        private val checkView: CheckBox = itemView.findViewById(R.id.testCheckView)

        fun bind(weakModel: TestCellModel?) {
            weakModel?.let { model ->
                // Parse image string with Coil, Picasso, Glide

                titleView.text = model.name
                checkView.isChecked = model.isChecked

                checkView.setOnCheckedChangeListener { _, isChecked ->
                    testAdapterClick?.onRuleCheckedChanged(isChecked, model)
                }
            }
        }
    }
}