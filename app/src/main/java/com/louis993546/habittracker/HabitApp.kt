package com.louis993546.habittracker

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.louis993546.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun HabitApp() {
    HabitTrackerTheme {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { Home(navController = navController) }
                composable("create") { UnderConstruction() }
                composable("details") { UnderConstruction() }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HabitAppPreview() {
    HabitTrackerTheme {
        HabitApp()
    }
}
