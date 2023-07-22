package com.satyajit.myshop.di.component

import androidx.lifecycle.ViewModelProvider
import com.satyajit.myshop.MyShopApp
import com.satyajit.myshop.di.module.ApplicationModule
import com.satyajit.myshop.ui.base.ViewModelProviderFactory
import com.satyajit.myshop.ui.homescreen.HomeViewModel
import com.satyajit.myshop.ui.searchscreen.SearchViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application:MyShopApp)

    fun getHomeViewModelFactory(): ViewModelProviderFactory<HomeViewModel>
    fun getSearchViewModelFactory(): ViewModelProviderFactory<SearchViewModel>
}