package com.stepanov.kinopoisk.repository.dto

import com.google.gson.annotations.SerializedName


data class TopDTO(
    @SerializedName("films")
    val films: List<FilmDTO>,
    @SerializedName("pagesCount")
    val pagesCount: Int
)