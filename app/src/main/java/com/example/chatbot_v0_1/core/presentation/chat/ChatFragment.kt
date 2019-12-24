package com.example.chatbot_v0_1.core.presentation.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot_v0_1.R
import com.example.chatbot_v0_1.core.domain.entity.Message
import com.example.chatbot_v0_1.core.presentation.chat.adapter.MessageAdapter
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.chat_fragment.*
import org.koin.core.KoinComponent
import org.koin.core.get
import java.util.*

class ChatFragment : KoinComponent, MvpFragment<ChatContract.View, ChatContract.Presenter>(),
    ChatContract.View {

    private lateinit var messageAdapter: MessageAdapter

    override fun createPresenter(): ChatContract.Presenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageAdapter = MessageAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chat_recycler_view.apply {
            adapter = messageAdapter
        }
        chat_recycler_view.layoutManager = LinearLayoutManager(context)
        sendButton.apply { setOnClickListener { presenter.sendMessage(editMessage.text.toString()) } }
        return_button.setOnClickListener { navigateToFeed() }
        presenter.sendMessage("Hi")

        //  messageAdapter.addItems(createMockMessages())
    }

    override fun showMyNewMessage(messageText: String) {
        val message = Message(messageText, GregorianCalendar(), true)
        messageAdapter.addItems(listOf(message))
    }

    override fun showBotNewMessage(messageText: String) {
        val message = Message(messageText, GregorianCalendar(), false)
        messageAdapter.addItems(listOf(message))
    }

    override fun clearText() {
        editMessage.setText("")
    }

    override fun navigateToFeed() {
        findNavController().navigate(R.id.feedFragment)
    }

    /* private fun createMockMessages(): List<Message> {
        val message = Message("this is the first message", GregorianCalendar(), true)
        val cal = GregorianCalendar().also { cal -> cal.set(2019, 12, 10, 14, 34, 30) }
        val message1 = Message("this is the second message", cal, false)
        return listOf(message, message1)
    }*/


}