package com.stevdzasan.courses.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.stevdzasan.courses.todocompose.navigation.SetupNavigation
import com.stevdzasan.courses.todocompose.ui.theme.ToDoComposeTheme
import com.stevdzasan.courses.todocompose.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController, sharedViewModel)
            }
        }
    }
}
