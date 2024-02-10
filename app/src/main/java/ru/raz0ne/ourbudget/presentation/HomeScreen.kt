package ru.raz0ne.ourbudget.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import ru.raz0ne.ourbudget.R
import ru.raz0ne.ourbudget.ui.navigation.AppBar
import ru.raz0ne.ourbudget.ui.navigation.Drawer

@Composable
fun HomeScreen() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    Drawer(
        drawerState = drawerState,
        scope = coroutineScope
    ) {
        Scaffold(
            topBar = {
                AppBar(
                    appBarTitle = stringResource(id = R.string.app_name),
                    onNavigationIconClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
        ) { contentPadding ->
            Surface(
                modifier = Modifier.fillMaxSize().padding(contentPadding)
            ) {

            }
        }
    }
}

@Preview(apiLevel = 33)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
