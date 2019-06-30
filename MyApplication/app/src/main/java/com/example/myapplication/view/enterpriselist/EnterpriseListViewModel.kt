package com.example.myapplication.view.enterpriselist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.model.EnterpriseInfo
import com.example.myapplication.model.EnterpriseRepository

class EnterpriseListViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var list:MutableList<EnterpriseInfo>

    fun getAllInfo(): MutableList<EnterpriseInfo> {
        list = EnterpriseRepository.getInstance(getApplication()).getListFromJson()
        return list
    }

}