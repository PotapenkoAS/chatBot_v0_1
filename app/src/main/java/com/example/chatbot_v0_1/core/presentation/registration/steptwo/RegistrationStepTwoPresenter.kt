package com.example.chatbot_v0_1.core.presentation.registration.steptwo

import android.util.Log
import com.example.chatbot_v0_1.core.data.source.network.response.UserResponse
import com.example.chatbot_v0_1.core.domain.entity.TempUserStorage
import com.example.chatbot_v0_1.core.domain.entity.User
import com.example.chatbot_v0_1.core.domain.usecase.RegistrationUseCase
import com.example.chatbot_v0_1.core.presentation.registration.steptwo.processor.OnClickProcessor
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.get

class RegistrationStepTwoPresenter : KoinComponent,
    MvpBasePresenter<RegistrationStepTwoContract.View>(),
    RegistrationStepTwoContract.Presenter {

    private val processor = OnClickProcessor()

    override fun process(
        firstName: String,
        lastName: String,
        patronymic: String,
        groupShortName: String
    ) {
        ifViewAttached { view ->
            if (processor.process(view, firstName, lastName, patronymic, groupShortName)) {
                val user = User(
                    TempUserStorage.login!!,
                    TempUserStorage.password!!,
                    firstName,
                    lastName,
                    patronymic,
                    groupShortName
                )
                get<RegistrationUseCase>().doApiRegistration(user)
                    .subscribe(
                        { response: UserResponse? ->
                            //TODO save returned User to local storage for fast enter
                            if (response == null || response.userId == 0) {
                                Log.d("MY_LOG", "server returned user with id==${response?.userId}")
                            }
                            TempUserStorage.firstName = response?.firstName
                            TempUserStorage.lastName = response?.lastName
                            TempUserStorage.patronymic = response?.patronymic
                            TempUserStorage.groupId = response?.groupId
                            TempUserStorage.departmentId = response?.departmentId
                            TempUserStorage.instituteId = response?.instituteId
                            TempUserStorage.id = response?.userId
                            view.navigateToChat()

                        },
                        { error: Throwable? -> error?.printStackTrace() })

            }

        }
    }
}