package com.example.android.daggerretrofitpicassoskeleton

import android.app.Application
import com.example.android.daggerretrofitpicassoskeleton.di.AppComponent
import com.example.android.daggerretrofitpicassoskeleton.di.DaggerAppComponent

class MyApp : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
    }
}
