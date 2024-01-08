package com.feature.movie.data.mapper

import com.anil.moviesapp.data.movies.GetMovies
import com.feature.movie.domain.model.Movie

fun GetMovies.toDomainMovieList(): List<Movie>{
    return this.results.map {
        Movie(it.adult,
            it.backdrop_path,
            it.genre_ids,
            it.id,
            it.original_language,
            it.original_title,
            it.overview,
            it.popularity,
            it.poster_path,
            it.release_date,
            it.title,
            it.video,
            it.vote_average,
            it.vote_count)
    }
}