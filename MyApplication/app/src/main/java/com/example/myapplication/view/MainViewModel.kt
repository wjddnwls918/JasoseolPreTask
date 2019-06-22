package com.example.myapplication.view

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.EnterInfo
import com.example.myapplication.model.EnterRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: EnterRepository = EnterRepository.getInstance(application)
    lateinit var list:MutableList<EnterInfo>

    fun getAllInfo(): MutableList<EnterInfo> {
        list = repository.getFromJson()
        return list
    }

}