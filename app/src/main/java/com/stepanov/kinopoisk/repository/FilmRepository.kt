package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.domain.Film

interface FilmRepository {
    fun getFilmsFromServer(callback: CallbackRemoteDataSource)
    fun getFilmById(id: Int): Film
}