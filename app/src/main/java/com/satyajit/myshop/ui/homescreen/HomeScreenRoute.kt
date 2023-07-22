package com.satyajit.myshop.ui.homescreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.satyajit.myshop.di.component.ApplicationComponent

@Composable
fun HomeScreenRoute(navHostController: NavHostController,applicationComponent: ApplicationComponent) {

    val homeViewModel: HomeViewModel =
        viewModel(factory = applicationComponent.getHomeViewModelFactory())

    HomeScreen(homeViewModel = homeViewModel)
}