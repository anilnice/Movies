package com.anil.movies.di

import com.anil.movies.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
        fun provideNavigationProvider(movieApi: MovieApi): NavigationProvider{
            return NavigationProvider(movieApi)
        }
}