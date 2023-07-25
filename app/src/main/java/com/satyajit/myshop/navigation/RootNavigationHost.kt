package com.satyajit.myshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satyajit.myshop.di.component.ApplicationComponent
import com.satyajit.myshop.ui.homescreen.HomeScreenRoute
import com.satyajit.myshop.ui.productdetailscreen.ProductDetailsRoute
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
                onSearchClicked = { navHostController.navigate(Graphs.SearchScreen.route) },
                applicationComponent = applicationComponent
            ) { productID ->
                navHostController.navigate(
                    "productDetailsScreen/$productID"
                )
            }

        }

        composable(Graphs.SearchScreen.route) {
            SearchScreenRoute(applicationComponent = applicationComponent) { productID ->
                navHostController.navigate(
                    "productDetailsScreen/$productID"
                )
            }
        }

        composable(Graphs.ProductDetailScreen.route,arguments = listOf(navArgument("productID") { type = NavType.StringType })) {backstart->
            ProductDetailsRoute(
                productId = backstart.arguments?.getString("productID") ?: "1",
                applicationComponent = applicationComponent
            ) { navHostController.popBackStack() }
        }
    }

}

sealed class Graphs(val route: String) {
    object SplashScreen : Graphs("splash")
    object HomeScreen : Graphs("homescreen")
    object SearchScreen : Graphs("searchScreen")
    object ProductDetailScreen : Graphs("productDetailsScreen/{productID}")
}