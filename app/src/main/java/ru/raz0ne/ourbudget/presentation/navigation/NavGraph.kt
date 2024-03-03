package ru.raz0ne.ourbudget.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.raz0ne.ourbudget.presentation.screens.HomeScreen
import ru.raz0ne.ourbudget.presentation.screens.SettingsScreen
import ru.raz0ne.ourbudget.presentation.screens.signIn.SignInScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.SignIn.route)
    {
        composable(route = NavigationItem.SignIn.route) {
            SignInScreen()
        }

        composable(route = NavigationItem.Tables.route) {
            HomeScreen()
        }

        composable(route = NavigationItem.Settings.route) {
            SettingsScreen()
        }

        composable(route = NavigationItem.Feedback.route) {

        }

        composable(route = NavigationItem.SignOut.route) {

        }
    }
}