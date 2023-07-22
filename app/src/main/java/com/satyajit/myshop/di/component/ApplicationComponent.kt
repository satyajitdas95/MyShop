package com.satyajit.myshop.di.component

import com.satyajit.myshop.MyShopApp
import com.satyajit.myshop.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application:MyShopApp)
}