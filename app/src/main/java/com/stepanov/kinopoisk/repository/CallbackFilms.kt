package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.domain.Film

interface CallbackFilms {
    fun onResponse(filmsList: List<Film>)
    fun onFailure(t: Throwable)
}