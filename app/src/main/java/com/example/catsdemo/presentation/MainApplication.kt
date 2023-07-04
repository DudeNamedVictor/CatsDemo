package com.example.catsdemo.presentation

import android.app.Application
import com.example.catsdemo.presentation.di.AppComponent
import com.example.catsdemo.presentation.di.DaggerAppComponent

open class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}