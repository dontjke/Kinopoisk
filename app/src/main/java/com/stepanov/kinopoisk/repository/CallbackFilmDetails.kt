package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.domain.FilmDetails

interface CallbackFilmDetails {
    fun onResponse(filmDetails: FilmDetails)
    fun onFailure(t: Throwable)
}