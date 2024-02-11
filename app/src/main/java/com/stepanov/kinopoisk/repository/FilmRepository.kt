package com.stepanov.kinopoisk.repository

interface FilmRepository {
    fun getFilmsFromServer(callback: CallbackFilms)
    fun getFilmById(id: Int, callback: CallbackFilmDetails)
}