package com.example.chatbot_v0_1.core.presentation.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot_v0_1.R
import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import com.example.chatbot_v0_1.core.presentation.feed.adapter.FeedAdapter
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.feed_fragment.*
import org.koin.core.KoinComponent
import org.koin.core.get

class FeedFragment : KoinComponent,
    MvpFragment<FeedContract.View, FeedContract.Presenter>(),
    FeedContract.View {

    private lateinit var feedItemAdapter: FeedAdapter

    override fun createPresenter(): FeedContract.Presenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedItemAdapter = FeedAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        feed_recycler_view.adapter = feedItemAdapter
        feed_recycler_view.layoutManager = LinearLayoutManager(context)
        presenter.loadFeed()
    }

    override fun showNews(items: ArrayList<FeedItem>) {
        feedItemAdapter.addItems(items)
    }


}