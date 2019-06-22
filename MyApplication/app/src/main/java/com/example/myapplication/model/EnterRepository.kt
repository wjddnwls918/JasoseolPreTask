package com.example.myapplication.model

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.reflect.Type


class EnterRepository(var application: Application) {

    companion object {
        private var INSTANCE: EnterRepository? = null

        fun getInstance(application: Application): EnterRepository {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(EnterRepository::class) {
                val instance = EnterRepository(application)
                INSTANCE = instance
                return instance
            }
        }
    }

    fun getFromJson(): ArrayList<EnterInfo> {
        var info: ArrayList<EnterInfo> = ArrayList()
        val gson = GsonBuilder().create()

        try {
            val inputStream:InputStream = application.assets.open("Android.json")
            val inputString = inputStream.bufferedReader().use{it.readText()}

            var list = gson.fromJson(inputString,Array<EnterInfo>::class.java).toList()

            info.addAll(list)

        } catch (e: Exception) {
            e.printStackTrace()
        }


        return info
    }

}