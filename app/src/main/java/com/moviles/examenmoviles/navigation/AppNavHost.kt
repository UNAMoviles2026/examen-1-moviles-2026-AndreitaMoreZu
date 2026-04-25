package com.movies.examenmovies.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.movies.examenmovies.ui.screens.ListScreen
import com.movies.examenmovies.ui.screens.DetailScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("list") {
            ListScreen(
                onSpaceClick = { spaceId ->
                    navController.navigate("detail/$spaceId")
                }
            )
        }

        composable(
            "detail/{spaceId}",
            arguments = listOf(navArgument("spaceId") { type = NavType.IntType })
        ) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getInt("spaceId") ?: 0
            DetailScreen(
                spaceId = spaceId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}