package com.example.navigationtemplate.ui.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationtemplate.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private val notificationsViewModel: NotificationsViewModel by viewModels()
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            text_notifications.text = it
        })
        //Safe way, because it expects
        btnToDashboard.setOnClickListener {
            navController
                .navigate(NotificationsFragmentDirections
                    .toDashboard("From Notification Fragment"))
        }
    }


}
