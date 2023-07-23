package com.satyajit.myshop.di.module

import android.content.Context
import com.satyajit.myshop.MyShopApp
import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.repository.HomeRepository
import com.satyajit.myshop.di.ApplicationContext
import com.satyajit.myshop.di.BaseUrl
import com.satyajit.myshop.ui.base.ViewModelProviderFactory
import com.satyajit.myshop.ui.homescreen.HomeViewModel
import com.satyajit.myshop.ui.searchscreen.SearchViewModel
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApplicationModule(private val application:MyShopApp) {

    @ApplicationContext
    @Provides
    fun provideContext() : Context{
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://dummyjson.com/"


    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }

    @Provides
    fun provideHomeViewModelFactory(homeScreenRepository: HomeRepository) : ViewModelProviderFactory<HomeViewModel>{
        return ViewModelProviderFactory(HomeViewModel::class){
            HomeViewModel(homeScreenRepository)
        }
    }

    @Provides
    fun provideSearchViewModelFactory() : ViewModelProviderFactory<SearchViewModel>{
        return ViewModelProviderFactory(SearchViewModel::class){
            SearchViewModel()
        }
    }


}