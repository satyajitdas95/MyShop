package com.satyajit.myshop.di.module

import android.content.Context
import com.satyajit.myshop.MyShopApp
import com.satyajit.myshop.di.ApplciationContext
import com.satyajit.myshop.ui.base.ViewModelProviderFactory
import com.satyajit.myshop.ui.homescreen.HomeViewModel
import com.satyajit.myshop.ui.searchscreen.SearchViewModel
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application:MyShopApp) {

    @ApplciationContext
    @Provides
    fun provideContext() : Context{
        return application
    }

    @Provides
    fun provideHomeViewModelFactory() : ViewModelProviderFactory<HomeViewModel>{
        return ViewModelProviderFactory(HomeViewModel::class){
            HomeViewModel()
        }
    }

    @Provides
    fun provideSearchViewModelFactory() : ViewModelProviderFactory<SearchViewModel>{
        return ViewModelProviderFactory(SearchViewModel::class){
            SearchViewModel()
        }
    }


}