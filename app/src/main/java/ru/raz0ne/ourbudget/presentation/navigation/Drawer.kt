package ru.raz0ne.ourbudget.presentation.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.raz0ne.ourbudget.R
import ru.raz0ne.ourbudget.ui.theme.Orange

@Composable
fun Drawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    val items = listOf(
        DrawerItem(
            id = "tables",
            title = "Таблицы",
            icon = ImageVector.vectorResource(id = R.drawable.baseline_wallet_24),
        ),
        DrawerItem(
            id = "settings",
            title = "Настройки",
            icon = Icons.Default.Settings,
        ),
        DrawerItem(
            id = "feedback",
            title = "Связь с разработчиком",
            icon = Icons.Default.MailOutline,
        ),
        DrawerItem(
            id = "logout",
            title = "Выйти",
            icon = Icons.AutoMirrored.Filled.ExitToApp,
        )
    )

    val selectedItem = remember {
        mutableStateOf(items[0])
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(320.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                        .paint(
                            painterResource(id = R.drawable.nav_drawer_background),
                            contentScale = ContentScale.FillBounds
                        )
                        .border(width = 1.dp, color = Orange),
                    //contentAlignment = Alignment.Center,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "profile picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(
                                    width = 1.dp,
                                    color = Orange,
                                    shape = CircleShape
                                )
                        )
                        Text(
                            text = "vlad.razon@mail.ru",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 4.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 22.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                items.dropLast(1).forEach{ item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = selectedItem.value == item,
                        icon = {
                           Icon(
                               imageVector = item.icon,
                               contentDescription = item.title
                           )
                        },
                        onClick = {
                            scope.launch {
                                selectedItem.value = item
                                drawerState.close()
                            }
                        }
                    )
                }
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                items.last().also { item ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = item.title,
                                color = Color.Red
                            )
                        },
                        selected = selectedItem.value == item,
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = Color.Red
                            )
                        },
                        onClick = {
                            scope.launch {
                                selectedItem.value = item
                                drawerState.close()
                            }
                        }
                    )
                }
            }
        },
        content = content
    )
}