package com.anil.moviesapp.data.movies

data class GetMovies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)