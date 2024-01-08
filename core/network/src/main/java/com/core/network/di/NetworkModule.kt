package com.core.network.di

import com.core.network.ApiService
import com.core.network.dataproviders.MovieDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    const val MOVIE_TOP_RATED = "top_rated"
    const val MOVIE_POPULAR = "popular"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    const val TOKEN =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0YjllYjBjOTVmMzAwMmU2MzQ4ZmM1YmNmZGZkZjIxOCIsInN1YiI6IjVmMTE0NTU3YzYxNmFjMDAzMzVjYTE0NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ssIzSbr3IW-3DAaxNWyeRY5iiywnyclLz0w4V-3giOU"

    const val SHARED_MOVIE_POPULAR = "movies"
    const val MOVIE_CREDITS = "{movie_id}/credits"
    const val MOVIE_REVIEWS = "{movie_id}/reviews"
    const val MOVIE_ID = "movie_id"

    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    var mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttpLoggingInterceptor)
        .addInterceptor(Interceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $TOKEN")
                .build()
            chain.proceed(newRequest)
        })
        .build()

    @Provides
    fun provideApiService(): ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideMovieDataProvider(apiService: ApiService): MovieDataProviders{
        return MovieDataProviders(apiService)
    }
}