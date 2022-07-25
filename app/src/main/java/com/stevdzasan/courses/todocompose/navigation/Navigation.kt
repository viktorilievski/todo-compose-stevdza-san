package com.stevdzasan.courses.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.stevdzasan.courses.todocompose.navigation.destinations.listComposable
import com.stevdzasan.courses.todocompose.navigation.destinations.taskComposable
import com.stevdzasan.courses.todocompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable (
            navigateToListScreen = screen.list
        )
    }
}