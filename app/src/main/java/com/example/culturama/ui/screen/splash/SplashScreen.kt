package com.example.culturama.ui.screen.splash

import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.culturama.ui.theme.Teal200
import com.example.culturama.R
import com.example.culturama.ui.navigation.Screen
import com.example.culturama.ui.theme.CulturamaTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (
    navController: NavHostController
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash (
    alpha: Float
) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Teal200)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.culturama),
            contentDescription = null,
            alpha = alpha
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    CulturamaTheme {
        Splash(alpha = 1f)
    }
}

