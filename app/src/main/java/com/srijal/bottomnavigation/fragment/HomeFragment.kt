package com.srijal.bottomnavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.srijal.bottomnavigation.R
import kotlinx.android.synthetic.main.fragment_home.view.open_notifications

/**
 * The Home fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).also {

            // Navigate to the notifications page when clicked.
            it.open_notifications.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.navigation_notifications)
            )
        }
    }
}
