package com.stepanov.kinopoisk.domain

data class Film(
    val id: Int,
    val nameRu: String,
    val posterUrlPreview: String,
    val genres: List<Genre>,
    val year: String
)