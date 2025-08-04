package com.example.jetpackegitim2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackegitim2.LoginScreen
import com.example.jetpackegitim2.RegisterScreen
import com.example.jetpackegitim2.ui.users.UsersScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigatioItem.Login.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigatioItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigatioItem.Users.route) {
            UsersScreen()
        }
        composable("${NavigatioItem.Register.route}/{nameSurname}"
        ) {
            val nameSurname = it.arguments?.getString("nameSurname") ?: ""
            RegisterScreen(navController, nameSurname)
        }
    }
}