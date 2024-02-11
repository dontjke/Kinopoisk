package com.stepanov.kinopoisk.domain

data class FilmDetails(
    val id: Int,
    val posterUrl: String,
    val description: String,
    val genres: Genre,
    val countries: Countries,
)