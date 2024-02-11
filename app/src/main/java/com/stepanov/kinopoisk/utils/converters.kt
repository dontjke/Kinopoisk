package com.stepanov.kinopoisk.utils

import com.stepanov.kinopoisk.domain.Film
import com.stepanov.kinopoisk.domain.FilmDetails
import com.stepanov.kinopoisk.repository.dto.FilmDTO
import com.stepanov.kinopoisk.repository.dto.FilmDetailsDTO


fun FilmDTO.toFilm(): Film {
    return Film(
        id = this.filmId,
        nameRu = this.nameRu,
        posterUrlPreview = this.posterUrlPreview,
        genres = this.genres.joinToString(", ") {
            it.genre
        },
        year = this.year

    )
}

fun FilmDetailsDTO.toFilmDetails(): FilmDetails {
    return FilmDetails(
        id = this.kinopoiskId,
        nameRu = this.nameRu,
        posterUrl = this.posterUrl,
        description = this.description,
        genres = this.genres.joinToString(", ") {
            it.genre
        },
        countries = this.countries.joinToString(", ") {
            it.country
        }
    )
}
