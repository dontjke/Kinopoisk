package com.stepanov.kinopoisk.utils

import com.stepanov.kinopoisk.domain.Film
import com.stepanov.kinopoisk.domain.Genre
import com.stepanov.kinopoisk.repository.dto.FilmDTO
import com.stepanov.kinopoisk.repository.dto.GenreDTO

const val SERVER_ERROR = "Ошибка сервера"
const val REQUEST_ERROR = "Ошибка запроса на сервер"
const val KINOPOISK_BASE_URL = "https://kinopoiskapiunofficial.tech"
const val KINOPOISK_API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"
const val KINOPOISK_END_POINT_TOP = "/api/v2.2/films/top"
const val KINOPOISK_HEADER_TOP = "x-api-key"

fun FilmDTO.toFilm(): Film {
    return Film(
        id = this.filmId,
        nameRu = this.nameRu,
        posterUrlPreview = this.posterUrlPreview,
        genres = this.genres.map {
            it.toGenre()
        },
        year = this.year

    )
}

fun GenreDTO.toGenre(): Genre {
    return Genre(
        genre = this.genre
    )
}