package com.example.culturama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.navigation.NavGraph
import com.example.culturama.ui.screen.login.LoginPage
import com.example.culturama.ui.screen.splash.SplashScreen
import com.example.culturama.ui.theme.CulturamaTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        setContent {
            CulturamaTheme {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colorScheme.background
                    )
                ) {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginPage(navController: NavHostController) {
        // Kode LoginPage Anda
        // Pastikan ini berada dalam konteks composable
    }
}
