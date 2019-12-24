package com.example.chatbot_v0_1.core.presentation.person

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

class PersonContract {
    interface View : MvpView {
        fun navigateToLogin()
        fun setGroupText(text: String)
        fun setDepartmentText(text: String)
        fun setInstituteText(text: String)
        fun setName(text: String)

    }

    interface Presenter : MvpPresenter<View> {
        fun getCommonInfo()
    }
}