package com.stevdzasan.courses.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.stevdzasan.courses.todocompose.ui.screens.task.TaskScreen
import com.stevdzasan.courses.todocompose.ui.viewmodels.SharedViewModel
import com.stevdzasan.courses.todocompose.util.Action
import com.stevdzasan.courses.todocompose.util.Constants
import com.stevdzasan.courses.todocompose.util.Constants.TASK_ARGUMENT_KEY

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(
            key1 = selectedTask
        ) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen,
            sharedViewModel = sharedViewModel
        )
    }
}