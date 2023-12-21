package com.example.culturama.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.screen.boarding.OnBoardingScreen
import com.example.culturama.ui.screen.boarding.OnBoardingViewModel
import com.example.culturama.ui.screen.home.HomeScreen
import com.example.culturama.ui.screen.navigator.CultureNavigator

@Composable
fun NavGraph (
    startDestination: String
) {
    val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = startDestination,
        ) {
            navigation(
                route = Route.AppStartNavigation.route,
                startDestination = Route.OnBoardingScreen.route
            ) {
                composable(
                    route = Route.OnBoardingScreen.route
                ) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }

            navigation(
                route = Route.CultureNavigation.route,
                startDestination = Route.CultureNavigatorScreen.route
            ) {
                composable(
                    route = Route.CultureNavigatorScreen.route
                ) {
                    CultureNavigator()
                }
            }
        }
    }
