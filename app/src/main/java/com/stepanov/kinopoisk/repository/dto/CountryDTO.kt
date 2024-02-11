package com.stepanov.kinopoisk.repository.dto


import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("country")
    val country: String
)