package com.example.chatbot_v0_1.core.presentation.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chatbot_v0_1.R
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import kotlinx.android.synthetic.main.person_fragment.*
import org.koin.core.KoinComponent
import org.koin.core.get

class PersonFragment : KoinComponent,
    MvpFragment<PersonContract.View, PersonContract.Presenter>(),
    PersonContract.View {


    override fun createPresenter(): PersonContract.Presenter = get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.person_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        presenter.getCommonInfo()
        sign_out_button.setOnClickListener { navigateToLogin() }
    }

    override fun navigateToLogin() {
        findNavController().navigate(R.id.loginFragment)
    }

    override fun setGroupText(text: String) {
        group_text.text = text
    }

    override fun setDepartmentText(text: String) {
        department_text.text = text
    }

    override fun setInstituteText(text: String) {
        institute_text.text = text
    }


}