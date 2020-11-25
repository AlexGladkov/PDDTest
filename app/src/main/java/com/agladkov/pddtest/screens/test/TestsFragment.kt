package com.agladkov.pddtest.screens.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agladkov.pddtest.R
import com.agladkov.pddtest.helpers.injectViewModel
import com.agladkov.pddtest.screens.PddTestApplication
import com.agladkov.pddtest.screens.test.adapter.TestAdapter
import com.agladkov.pddtest.screens.test.adapter.TestAdapterClick
import com.agladkov.pddtest.screens.test.models.TestCellModel
import kotlinx.android.synthetic.main.fragment_tests.*
import javax.inject.Inject

class TestsFragment: Fragment(R.layout.fragment_tests) {

    private var authToken: String? = null
    private val testAdapter = TestAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as? PddTestApplication)?.appComponent?.inject(this)
        super.onCreate(savedInstanceState)

        authToken = arguments?.getString(tokenKey)

        testAdapter.setTestAdapterClick(object: TestAdapterClick {
            override fun onRuleCheckedChanged(isChecked: Boolean, model: TestCellModel) {
                Toast.makeText(context, "Rule ${model.name}, isChecked = $isChecked", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testViewModel = injectViewModel(factory = viewModelFactory)

        itemsView.adapter = testAdapter
        itemsView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        configureViewModel()
        testViewModel.generateData()
    }

    private fun configureViewModel() {
        testViewModel.items.observe(viewLifecycleOwner, Observer { data ->
            testAdapter.setData(data)
        })
        testViewModel.error.observe(viewLifecycleOwner, Observer { error ->
            if (error.isNotBlank()) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        const val tokenKey = "authToken"
    }
}