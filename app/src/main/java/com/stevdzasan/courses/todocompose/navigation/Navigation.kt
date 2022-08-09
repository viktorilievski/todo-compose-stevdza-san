package com.stevdzasan.courses.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.stevdzasan.courses.todocompose.navigation.destinations.listComposable
import com.stevdzasan.courses.todocompose.navigation.destinations.splashComposable
import com.stevdzasan.courses.todocompose.navigation.destinations.taskComposable
import com.stevdzasan.courses.todocompose.ui.viewmodels.SharedViewModel
import com.stevdzasan.courses.todocompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}