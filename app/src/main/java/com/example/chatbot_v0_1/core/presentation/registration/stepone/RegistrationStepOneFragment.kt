package com.example.chatbot_v0_1.core.presentation.registration.stepone

import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.chatbot_v0_1.R
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.registration_fragment_step_one.*
import org.koin.core.KoinComponent
import org.koin.core.get

class RegistrationStepOneFragment : KoinComponent,
    MvpFragment<RegistrationStepOneContract.View, RegistrationStepOneContract.Presenter>(),
    RegistrationStepOneContract.View {
    override fun createPresenter(): RegistrationStepOneContract.Presenter = get()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registration_fragment_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        next_step_button.setOnClickListener {
            presenter.processClick(
                registrationLogin.text.toString(),
                registrationPassword.text.toString(),
                registrationConfirmPassword.text.toString()
            )
        }
        registrationLogin.addTextChangedListener { hideLoginValidationError() }
        registrationPassword.addTextChangedListener { hidePasswordValidationError() }
        registrationConfirmPassword.addTextChangedListener { hideConfirmPasswordValidationError() }
    }

    override fun navigateToStepTwo() {
        findNavController().navigate(R.id.registrationStepTwo)
    }

    override fun showLoginValidationError() {
        login_error.text = context?.getString(R.string.login_validation_error)
    }

    override fun hideLoginValidationError() {
        login_error.text = ""
    }

    override fun showPasswordValidationError() {
        password_error.text = context?.getString(R.string.password_validation_error)
    }

    override fun hidePasswordValidationError() {
        password_error.text = ""
    }

    override fun showConfirmPasswordValidationError() {
        password_error.text = context?.getString(R.string.password_confirm_validation_error)
    }

    override fun hideConfirmPasswordValidationError() {
        password_error.text = ""
    }

}