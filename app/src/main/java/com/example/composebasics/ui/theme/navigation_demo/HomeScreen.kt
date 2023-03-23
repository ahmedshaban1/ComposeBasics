package com.example.composebasics.ui.theme.navigation_demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column() {
            Text(modifier = Modifier.clickable {
                navController.navigate(Screen.Details.getFullRoute(10))
            }, text = "Go to Details 1",
                 style = MaterialTheme.typography.h5)


            Spacer(modifier = Modifier.height(20.dp))

            Text(modifier = Modifier.clickable {
                navController.navigate(Screen.Details2.getFullRoute(100))
            }, text = "Go to Details 2",
                 style = MaterialTheme.typography.h5)
        }

    }
}
@Composable
@Preview(showBackground = true)
fun HomePreview(){
    HomeScreen(rememberNavController())
}