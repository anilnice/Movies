package com.feature.movie.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface MovieApi : FeatureApi {

}

class MovieApiImpl : MovieApi{
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        InternalMovieFeatureApi.registerGraph(
            navHostController,navGraphBuilder
        )
    }

}