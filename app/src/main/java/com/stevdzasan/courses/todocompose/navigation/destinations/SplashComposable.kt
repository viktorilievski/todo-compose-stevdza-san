package com.stevdzasan.courses.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.stevdzasan.courses.todocompose.ui.screens.splash.SplashScreen
import com.stevdzasan.courses.todocompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}