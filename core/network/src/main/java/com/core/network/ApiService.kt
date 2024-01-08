package com.core.network

import com.anil.moviesapp.data.actors.MovieActors
import com.anil.moviesapp.data.movies.GetMovies
import com.anil.moviesapp.data.reviews.MovieReviews
import com.core.network.di.NetworkModule.MOVIE_CREDITS
import com.core.network.di.NetworkModule.MOVIE_ID
import com.core.network.di.NetworkModule.MOVIE_POPULAR
import com.core.network.di.NetworkModule.MOVIE_REVIEWS
import com.core.network.di.NetworkModule.MOVIE_TOP_RATED
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(MOVIE_POPULAR)
    suspend fun getPopularMovies(): GetMovies

    @GET(MOVIE_TOP_RATED)
    suspend fun getTopRatedMovies(): GetMovies

    @GET(MOVIE_CREDITS)
    suspend fun getMovieCredits(@Path(MOVIE_ID) movieId: String): MovieActors

    @GET(MOVIE_REVIEWS)
    suspend fun getMovieReviews(@Path(MOVIE_ID) movieId: String): MovieReviews
}