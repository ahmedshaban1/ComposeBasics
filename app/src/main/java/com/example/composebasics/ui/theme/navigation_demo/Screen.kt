package com.example.composebasics.ui.theme.navigation_demo

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Details : Screen(route = "details/{id}"){
        fun getFullRoute(id:Int):String{
            return "details/$id"
        }
    }
    object Details2 : Screen(route = "details2?id={id}"){
        fun getFullRoute(id:Int):String{
            return "details2?id=$id"
        }
    }
}