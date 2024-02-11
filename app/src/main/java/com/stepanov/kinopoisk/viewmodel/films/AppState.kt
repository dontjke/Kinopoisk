package com.stepanov.kinopoisk.viewmodel.films

import com.stepanov.kinopoisk.domain.Film

sealed class AppState {
    data object Loading : AppState()
    data class Success(val filmsList: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
}

