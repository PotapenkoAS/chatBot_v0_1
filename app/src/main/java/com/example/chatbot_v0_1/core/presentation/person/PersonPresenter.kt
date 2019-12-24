package com.example.chatbot_v0_1.core.presentation.person

import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.request.DeviceIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import com.example.chatbot_v0_1.core.domain.entity.TempUserStorage
import com.example.chatbot_v0_1.core.domain.usecase.CatalogUseCase
import com.example.chatbot_v0_1.core.domain.usecase.LoginUseCase
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.get

class PersonPresenter : KoinComponent,
    MvpBasePresenter<PersonContract.View>(),
    PersonContract.Presenter {

    private val catalogUseCase = get<CatalogUseCase>()
    private val loginUseCase = get<LoginUseCase>()

    override fun getCommonInfo() {
        ifViewAttached { view ->
            val request = CatalogIdRequest(
                TempUserStorage.groupId!!,
                TempUserStorage.departmentId!!,
                TempUserStorage.instituteId!!
            )
            catalogUseCase.doGetCommonInfo(request).subscribe(
                { response: CatalogIdResponse? ->
                    view.setName("${TempUserStorage.lastName} ${TempUserStorage.firstName} ${TempUserStorage.patronymic}")
                    view.setGroupText("${response?.group?.fullName}")
                    view.setDepartmentText("${response?.department?.fullName}")
                    view.setInstituteText("${response?.institute?.fullName}")
                },
                { error: Throwable? ->
                    error?.printStackTrace()
                }
            )
        }
    }

    override fun signOut() {
        ifViewAttached { view ->
            loginUseCase.doApiSignOut(DeviceIdRequest(TempUserStorage.deviceId!!)).subscribe(
                { response: Boolean ->
                    if (response) view.navigateToLogin()

                },
                { error: Throwable? -> error?.printStackTrace() }
            )
        }
    }

}