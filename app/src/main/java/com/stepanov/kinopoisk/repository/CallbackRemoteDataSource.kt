package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.domain.Film

interface CallbackRemoteDataSource {
    fun onResponse(filmsList: List<Film>)
    fun onFailure(t: Throwable)
}