package com.stepanov.kinopoisk.viewmodel.filmdetails

import com.stepanov.kinopoisk.domain.FilmDetails

sealed class FilmDetailsState {
    data object Loading : FilmDetailsState()
    data class Success(val filmDetails: FilmDetails) : FilmDetailsState()
    data class Error(val error: Throwable) : FilmDetailsState()
}
