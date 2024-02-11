package com.stepanov.kinopoisk.domain

data class FilmDetails(
    val id: Int,
    val nameRu: String,
    val posterUrl: String,
    val description: String,
    val genres: String,
    val countries: String,
)