package com.agladkov.pddtest.screens.launcher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.agladkov.pddtest.R
import com.agladkov.pddtest.screens.test.TestsFragment
import kotlinx.android.synthetic.main.fragment_launcher.*

class LauncherFragment : Fragment(R.layout.fragment_launcher) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButtonView.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_launcherFragment_to_testsFragment,
                    Bundle().apply {
                        this.putString(TestsFragment.tokenKey, "TestAuthToken")
                    })
        }
    }
}