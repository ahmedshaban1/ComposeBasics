package com.example.composebasics.ui.theme.navigation_demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            Screen.Details.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {

            DetailsScreen(navController, it.arguments?.getInt("id"))
        }


        composable(
            Screen.Details2.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
            DetailsScreen(navController, it.arguments?.getInt("id"))
        }
    }
}