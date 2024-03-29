package com.example.pbbsattendance.view

import android.app.Application
import com.example.data.operator.GlobalResponseOperator
import com.skydoves.sandwich.SandwichInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication:Application() {
    companion object {
        private lateinit var application: MainApplication
        fun getInstance() : MainApplication = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        SandwichInitializer.sandwichOperators += GlobalResponseOperator<Any>(success = {it},this)
    }
}