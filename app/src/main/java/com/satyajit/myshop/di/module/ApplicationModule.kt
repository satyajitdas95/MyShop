package com.satyajit.myshop.di.module

import android.content.Context
import com.satyajit.myshop.MyShopApp
import com.satyajit.myshop.di.ApplciationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application:MyShopApp) {

    @ApplciationContext
    @Provides
    fun provideContext() : Context{
        return application
    }


}