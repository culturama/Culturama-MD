package com.example.culturama.ui.screen.home.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.culturama.R
import com.example.culturama.ui.navigation.NavigationItem
import com.example.culturama.ui.navigation.Route
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun BottomBar (
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar (
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.home),
                icon = R.drawable.ic_home,
                route = Route.HomeScreen
            ),
            NavigationItem(
                title = stringResource(R.string.favourite),
                icon = R.drawable.ic_fav,
                route = Route.FavoriteScreen
            ),
            NavigationItem(
                title = stringResource(R.string.profile),
                icon = R.drawable.ic_profile,
                route = Route.ProfileScreen
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.route.route,
                onClick = {
                    navController.navigate(item.route.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    CulturamaTheme {
        BottomBar(navController = navController)
    }
}