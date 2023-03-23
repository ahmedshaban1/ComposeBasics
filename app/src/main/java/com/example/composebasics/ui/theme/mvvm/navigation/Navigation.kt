package com.example.composebasics.ui.theme.mvvm.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composebasics.ui.theme.mvvm.presentation.NoteDetailsScreen
import com.example.composebasics.ui.theme.mvvm.presentation.NotesListScreen

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "noteList"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("noteList") {
            NotesListScreen {
                navController.navigate("note_details/$it")
            }
        }
        composable("note_details/{id}") {
            NoteDetailsScreen{
                navController.navigateUp()
            }
        }

    }
}