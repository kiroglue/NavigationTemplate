package com.example.navigationtemplate.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationtemplate.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

	private val homeViewModel: HomeViewModel by viewModels()
	private lateinit var navController :NavController

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		navController = Navigation.findNavController(view)

		homeViewModel.text.observe(viewLifecycleOwner, Observer {
			text_home.text = it
		})

		//unsafe: Because do not check dashboard arguments. Do not use! Instead, use it as in Notification Fragment
		//it will crash in Notification Fragment
		/*  btnToDashboard.setOnClickListener {
			navController.navigate(R.id.action_navigation_home_to_navigation_dashboard)
		}*/
		btnToDashboard.setOnClickListener {
			val bundle = bundleOf("sourceFrag" to "from Home Fragment")
			navController.navigate(R.id.action_navigation_home_to_navigation_dashboard,bundle)
		}

		btnToNotification.setOnClickListener {
			navController.navigate(R.id.action_navigation_home_to_navigation_notifications)
		}
	}
}
