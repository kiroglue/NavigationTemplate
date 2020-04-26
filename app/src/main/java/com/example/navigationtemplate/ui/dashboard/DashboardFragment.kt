package com.example.navigationtemplate.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationtemplate.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

	private val dashboardViewModel: DashboardViewModel by viewModels()
	private lateinit var navController : NavController
	private val args: DashboardFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		navController = Navigation.findNavController(view)

		dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
			text_dashboard.text = it
		})

		txtSource.text = args.sourceFrag

	}

}
