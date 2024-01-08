package com.anil.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.MovieFeature

@Composable
fun AppNavGraph(navHostController: NavHostController, navigationProvider: NavigationProvider) {
    NavHost(navController = navHostController, startDestination = MovieFeature.nestedRoute){
        navigationProvider.movieApi.registerGraph(
            navHostController = navHostController,this
        )
    }
}