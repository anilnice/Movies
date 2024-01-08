package com.feature.movie.ui.navigation.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class MovieViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) : ViewModel() {

    private val _movielist = mutableStateOf(MovieStateHolder())
    val movieList:State<MovieStateHolder> get() = _movielist

    init {
        getMovieList()
    }

    fun getMovieList() = viewModelScope.launch {
        getMovieListUseCase().onEach {
            when(it){
                is UiEvent.Loading -> {
                    _movielist.value = MovieStateHolder(isLoading = true)
                }
                is UiEvent.Success ->{
                    _movielist.value = MovieStateHolder(data = it.data)
                }
                is UiEvent.Error -> {
                    _movielist.value = MovieStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}