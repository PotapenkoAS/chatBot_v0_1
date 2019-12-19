package com.example.chatbot_v0_1.core.presentation.registration.steptwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.chatbot_v0_1.R
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.registration_fragment_step_two.*
import org.koin.core.KoinComponent
import org.koin.core.get

class RegistrationStepTwoFragment : KoinComponent,
    MvpFragment<RegistrationStepTwoContract.View, RegistrationStepTwoContract.Presenter>(),
    RegistrationStepTwoContract.View {
    override fun createPresenter(): RegistrationStepTwoContract.Presenter = get()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registration_fragment_step_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        finish_button.setOnClickListener {
            presenter.process(
                firstName.text.toString(),
                lastName.text.toString(),
                patronymic.text.toString(),
                group.text.toString()
            )
        }
        firstName.addTextChangedListener { hideError() }
        lastName.addTextChangedListener { hideError() }
    }

    override fun navigateToChat() {
        findNavController().navigate(R.id.chatFragment)
    }

    override fun showError() {
        error.text = context?.getString(R.string.fio_validation_error)
    }

    override fun hideError() {
        error.text = ""
    }


}