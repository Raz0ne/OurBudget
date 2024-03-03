package ru.raz0ne.ourbudget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.raz0ne.ourbudget.presentation.navigation.AppBar
import ru.raz0ne.ourbudget.presentation.navigation.Drawer
import ru.raz0ne.ourbudget.presentation.navigation.NavGraph
import ru.raz0ne.ourbudget.presentation.screens.HomeScreen
import ru.raz0ne.ourbudget.ui.theme.OurBudgetTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    OurBudgetTheme {

        val navController = rememberNavController()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val coroutineScope = rememberCoroutineScope()

        //val titleViewModel

        Drawer(
            navController = navController,
            drawerState = drawerState,
            scope = coroutineScope
        ) {
            NavGraph(
                navController = navController
            )
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    AppBar(
                        navController = navController,
                        onNavigationIconClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                    )
                },
            ) { paddingValues ->

            }
        }
    }
}
