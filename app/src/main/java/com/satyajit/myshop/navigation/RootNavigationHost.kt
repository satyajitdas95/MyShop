package com.satyajit.myshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.ui.homescreen.HomeScreenRoute
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
                navHostController = navHostController,
                applicationComponent = applicationComponent
            )
        }
    }

}

sealed class Graphs(val route: String) {
    object SplashScreen : Graphs("splash")
    object HomeScreen : Graphs("homescreen")
}