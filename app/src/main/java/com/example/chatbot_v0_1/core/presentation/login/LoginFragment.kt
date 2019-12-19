package com.example.chatbot_v0_1.core.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chatbot_v0_1.R
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.chat_fragment.*
import kotlinx.android.synthetic.main.login_fragment.*
import org.koin.core.KoinComponent
import org.koin.core.get

class LoginFragment : KoinComponent,
    MvpFragment<LoginContract.View, LoginContract.Presenter>(),
    LoginContract.View {

    override fun createPresenter(): LoginContract.Presenter = get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        loginButton.setOnClickListener {
            presenter.login(login.text.toString(), password.text.toString())
        }
        signUpButton.setOnClickListener { navigateToRegistration() }
    }

    override fun navigateToChat() {
        findNavController().navigate(R.id.chatFragment)
    }

    override fun navigateToRegistration() {
        findNavController().navigate(R.id.registrationStepOne)
    }
}