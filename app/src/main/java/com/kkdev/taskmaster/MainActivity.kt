package com.kkdev.taskmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kkdev.taskmaster.screens.AddTask
import com.kkdev.taskmaster.screens.HomeScreen
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController = navController) // Pass navController
                    }
                    composable("addTask") {
                        AddTask(navController = navController) // Render your Add Task screen
                    }
                    // ... other screens
                }            }
        }
    }
}
