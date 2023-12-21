package com.example.culturama.ui.screen.navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.culturama.R
import com.example.culturama.ui.navigation.NavigationItem
import com.example.culturama.ui.navigation.Route
import com.example.culturama.ui.screen.fav.FavouriteScreen
import com.example.culturama.ui.screen.home.HomeScreen
import com.example.culturama.ui.screen.profile.ProfileScreen
import com.example.culturama.ui.theme.CulturamaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CultureNavigator() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_fav, text = "Favourite"),
            BottomNavigationItem(icon = R.drawable.ic_profile, text = "Profile")

        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.FavoriteScreen.route -> 1
        Route.ProfileScreen.route -> 2
        else -> 0
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            CultureBottomNavigation(
                items = bottomNavigationItems,
                selected = selectedItem,
                onItemClick = { index ->
                    when(index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )
                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.FavoriteScreen.route
                        )
                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.ProfileScreen.route
                        )
                    }
                }
            )
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen()
            }

            composable(route = Route.FavoriteScreen.route) {
                FavouriteScreen()
            }

            composable(route = Route.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CultureNavigatorPreview() {
    CulturamaTheme {
        CultureNavigator()
    }
}

fun navigateToTab(
    navController: NavController,
    route: String
) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homescreen ->
            popUpTo(homescreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }

}

//@Composable
//fun CultureNavigator (
//    modifier: Modifier = Modifier,
//    navController: NavHostController
//) {
//    NavigationBar (
//        modifier = modifier
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//        val navigationItems = listOf(
//            NavigationItem(
//                title = stringResource(R.string.home),
//                icon = R.drawable.ic_home,
//                route = Route.HomeScreen
//            ),
//            NavigationItem(
//                title = stringResource(R.string.favourite),
//                icon = R.drawable.ic_fav,
//                route = Route.FavoriteScreen
//            ),
//            NavigationItem(
//                title = stringResource(R.string.profile),
//                icon = R.drawable.ic_profile,
//                route = Route.ProfileScreen
//            )
//        )
//
//        navigationItems.map { item ->
//            NavigationBarItem(
//                selected = currentRoute == item.route.route,
//                onClick = {
//                    navController.navigate(item.route.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        restoreState = true
//                        launchSingleTop = true
//                    }
//                },
//                icon = {
//                    Icon(
//                        painter = painterResource(item.icon),
//                        contentDescription = null
//                    )
//                }
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun BottomBarPreview() {
//    val navController = rememberNavController()
//    CulturamaTheme {
//        CultureNavigator(navController = navController)
//    }
//}