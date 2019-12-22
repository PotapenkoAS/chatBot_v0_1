package com.example.chatbot_v0_1.core.presentation.feed.adapter

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot_v0_1.R
import com.example.chatbot_v0_1.core.DATE_TIME_FEED_FORMAT
import com.example.chatbot_v0_1.core.domain.entity.FeedItem
import kotlin.collections.ArrayList

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private var feedList: ArrayList<FeedItem> = ArrayList()


    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemTitle: TextView? = itemView.findViewById(R.id.feed_item_title)
        private val itemText: TextView? = itemView.findViewById(R.id.feed_item_text)
        private val itemImage: ImageView? = itemView.findViewById(R.id.feed_item_image)
        private val itemTime: TextView? = itemView.findViewById(R.id.feed_item_time)


        fun bind(item: FeedItem) {
            itemTitle?.text = item.title
            itemText?.text = item.text
            if (item.image != null && item.image != "") {
                val byteArray = Base64.decode(item.image, Base64.DEFAULT)
                itemImage?.setImageBitmap(
                    BitmapFactory.decodeByteArray(
                        byteArray,
                        0,
                        byteArray.size
                    )
                )
            }
            itemTime?.text = String.format(item.dateTime.toString(), DATE_TIME_FEED_FORMAT)
        }
    }

    fun addItems(items: ArrayList<FeedItem>) {
        feedList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feedList[position])
    }
}