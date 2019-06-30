package com.example.myapplication.model

import android.app.Application
import com.google.gson.GsonBuilder
import java.io.*


class EnterpriseRepository(var application: Application) {

    companion object {
        private var INSTANCE: EnterpriseRepository? = null

        fun getInstance(application: Application): EnterpriseRepository {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(EnterpriseRepository::class) {
                val instance = EnterpriseRepository(application)
                INSTANCE = instance
                return instance
            }
        }
    }

    fun getListFromJson(): ArrayList<EnterpriseInfo> {
        var info: ArrayList<EnterpriseInfo> = ArrayList()
        val gson = GsonBuilder().create()

        try {
            val inputStream:InputStream = application.assets.open("Android.json")
            val inputString = inputStream.bufferedReader().use{it.readText()}

            info.addAll(gson.fromJson(inputString,Array<EnterpriseInfo>::class.java).toList())

        } catch (e: Exception) {
            e.printStackTrace()
        }


        return info
    }

}