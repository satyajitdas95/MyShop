package com.satyajit.myshop

import android.app.Application
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.di.component.DaggerApplicationComponent
import com.satyajit.myshop.di.module.ApplicationModule

class MyShopApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .build()
    }
}
