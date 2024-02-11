package com.stepanov.kinopoisk.repository.dto

import com.google.gson.annotations.SerializedName


data class GenreDTO(
    @SerializedName("genre")
    val genre: String
)