package ru.raz0ne.ourbudget.presentation.navigation

sealed class Screens(val route: String) {
    data object SignIn: Screens("sign_in")
    data object Table: Screens("table")
    data object Settings: Screens("settings")
}
