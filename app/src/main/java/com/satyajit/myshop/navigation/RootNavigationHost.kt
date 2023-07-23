package com.satyajit.myshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.ui.homescreen.HomeScreenRoute
import com.satyajit.myshop.ui.productdetailscreen.ProductDetailsScreen
import com.satyajit.myshop.ui.searchscreen.SearchScreenRoute
import com.satyajit.myshop.ui.splashscreen.SplashScreen

@Composable
fun RootNavHost(navHostController: NavHostController, applicationComponent: ApplicationComponent) {
    NavHost(navController = navHostController, startDestination = Graphs.SplashScreen.route) {
        composable(Graphs.SplashScreen.route) {
            SplashScreen(
                onSplashCompleted = { navHostController.navigate(Graphs.HomeScreen.route) })
        }

        composable(Graphs.HomeScreen.route) {
            HomeScreenRoute(
                onSearchClicked = {navHostController.navigate(Graphs.SearchScreen.route)},
                applicationComponent = applicationComponent
            )
        }

        composable(Graphs.SearchScreen.route){
            SearchScreenRoute(applicationComponent = applicationComponent)
        }

        composable(Graphs.ProductDetailScreen.route){
            ProductDetailsScreen(applicationComponent = applicationComponent)
        }
    }

}

sealed class Graphs(val route: String) {
    object SplashScreen : Graphs("splash")
    object HomeScreen : Graphs("homescreen")
    object SearchScreen : Graphs("searchScreen")
    object ProductDetailScreen : Graphs("productDetailsScreen")
}