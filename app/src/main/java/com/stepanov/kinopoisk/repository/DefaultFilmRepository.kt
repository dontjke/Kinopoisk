package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.domain.Film


class DefaultFilmRepository(
    private val remoteDataSource: RemoteDataSource
) : FilmRepository {

    override fun getFilmsFromServer(callback: CallbackRemoteDataSource) {
        remoteDataSource.getFilms(callback)
    }

    override fun getFilmById(id: Int): Film {
        TODO("Not yet implemented")
    }
}