package com.example.chatbot_v0_1.core.presentation.person

import com.example.chatbot_v0_1.core.data.source.network.request.CatalogIdRequest
import com.example.chatbot_v0_1.core.data.source.network.response.CatalogIdResponse
import com.example.chatbot_v0_1.core.domain.entity.TempUserStorage
import com.example.chatbot_v0_1.core.domain.usecase.CatalogUseCase
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import org.koin.core.KoinComponent
import org.koin.core.get

class PersonPresenter : KoinComponent,
    MvpBasePresenter<PersonContract.View>(),
    PersonContract.Presenter {

    private val catalogUseCase = get<CatalogUseCase>()

    override fun getCommonInfo() {
        ifViewAttached { view ->
            val request = CatalogIdRequest(
                TempUserStorage.groupId!!,
                TempUserStorage.departmentId!!,
                TempUserStorage.instituteId!!
            )
            catalogUseCase.doGetCommonInfo(request).subscribe(
                { response: CatalogIdResponse? ->
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

}