package com.example.chatbot_v0_1.core.presentation.chat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbot_v0_1.R
import com.example.chatbot_v0_1.core.DATE_TIME_FORMAT
import com.example.chatbot_v0_1.core.TIME_FORMAT
import com.example.chatbot_v0_1.core.domain.entity.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private var messageList: ArrayList<Message> = ArrayList()
    private val MY_MESSAGE_TYPE = 1
    private val BOT_MESSAGE_TYPE = 2

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val myMessageTextView: TextView? = itemView.findViewById(R.id.my_message_text_view)
        private val myTimeView: TextView? = itemView.findViewById(R.id.my_time_view)
        private val botMessageTextView: TextView? =
            itemView.findViewById(R.id.bot_message_text_view)
        private val botTimeView: TextView? = itemView.findViewById(R.id.bot_time_view)

        fun bind(message: Message) {
            myMessageTextView?.text = message.message
            setDateToMyTimeView(myTimeView, message.dateTime)

            botMessageTextView?.text = message.message
            setDateToMyTimeView(botTimeView, message.dateTime)
        }

        private fun setDateToMyTimeView(timeView: TextView?, date: GregorianCalendar) {
            if (GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR) > date.get(
                    Calendar.DAY_OF_YEAR
                )
            ) {
                timeView?.text =
                    SimpleDateFormat(
                        DATE_TIME_FORMAT,
                        Locale.US
                    ).format(Date(date.timeInMillis)) //check datetime with locale, mb should use mobile locale, not US
            } else {
                timeView?.text =
                    SimpleDateFormat(TIME_FORMAT, Locale.US).format(Date(date.timeInMillis))
            }
        }

    }

    fun addItems(items: List<Message>) {
        messageList.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        messageList.clear()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {

        return if (viewType == MY_MESSAGE_TYPE) {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_message_item_view, parent, false)
            MessageViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.bot_message_item_view, parent, false)
            MessageViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (messageList[position].isMine) {
            return MY_MESSAGE_TYPE
        }
        return BOT_MESSAGE_TYPE
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

}