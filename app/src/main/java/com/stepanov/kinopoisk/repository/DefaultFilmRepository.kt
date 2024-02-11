package com.stepanov.kinopoisk.repository


class DefaultFilmRepository(
    private val remoteDataSource: RemoteDataSource
) : FilmRepository {

    override fun getFilmsFromServer(callback: CallbackFilms) {
        remoteDataSource.getFilms(callback)
    }

    override fun getFilmById(id: Int, callback: CallbackFilmDetails) {
        remoteDataSource.getFilmDetails(id, callback)
    }
}