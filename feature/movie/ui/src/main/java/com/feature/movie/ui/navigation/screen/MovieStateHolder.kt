package com.feature.movie.ui.navigation.screen

import com.core.common.UiEvent
import com.feature.movie.domain.model.Movie

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
