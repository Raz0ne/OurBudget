package ru.raz0ne.ourbudget.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.raz0ne.ourbudget.R

sealed class NavigationItem(
    var route: String,
    var title:String? = null,
    var icon: ImageVector? = null,
    var iconRes: Int? = null,
    var isDrawerVisible: Boolean = false,
    var isAppBarVisible: Boolean = false
) {

    data object Tables : NavigationItem(
        route = "tables",
        title = "Tables",
        iconRes = R.drawable.baseline_wallet_24,
        isDrawerVisible = true,
        isAppBarVisible = true
    )

    data object Settings : NavigationItem(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings,
        isDrawerVisible = true,
        isAppBarVisible = true
    )

    data object Feedback : NavigationItem(
        route = "feedback",
        title = "Feedback",
        icon = Icons.Default.MailOutline,
        isDrawerVisible = true
    )

    data object SignOut : NavigationItem(
        route = "sign_out",
        title = "Sign out",
        icon = Icons.AutoMirrored.Filled.ExitToApp,
        isDrawerVisible = true
    )

    data object SignIn : NavigationItem(
        route = "sign_in"
    )

    companion object {
        val items = listOf(
            Tables,
            Settings,
            Feedback,
            SignOut,
            SignIn
        )

        fun getItem(route: String?): NavigationItem {
            return items.find { it.route == route } ?: Tables
        }
    }
}