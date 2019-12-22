package com.example.chatbot_v0_1.core.presentation.navigation_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chatbot_v0_1.R
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.navigation_bar_fragment.*
import org.koin.core.KoinComponent
import org.koin.core.get

class NavigationBarFragment : KoinComponent,
    MvpFragment<NavigationBarContract.View, NavigationBarContract.Presenter>(),
    NavigationBarContract.View {
    override fun createPresenter(): NavigationBarContract.Presenter = get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigation_bar_fragment, container, true)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        nav_to_feed_button.setOnClickListener { if (findNavController().currentDestination?.id != R.id.feedFragment) navigateToFeed() }
    }

    override fun navigateToFeed() {
        findNavController().navigate(R.id.feedFragment)
    }
}