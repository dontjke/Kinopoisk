package com.stepanov.kinopoisk.repository.dto


import com.google.gson.annotations.SerializedName

data class FilmDTO(
    @SerializedName("countries")
    val countries: List<CountryDTO>,
    @SerializedName("filmId")
    val filmId: Int,
    @SerializedName("filmLength")
    val filmLength: String,
    @SerializedName("genres")
    val genres: List<GenreDTO>,
    @SerializedName("isAfisha")
    val isAfisha: Int,
    @SerializedName("isRatingUp")
    val isRatingUp: Any,
    @SerializedName("nameEn")
    val nameEn: String,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("ratingChange")
    val ratingChange: Any,
    @SerializedName("ratingVoteCount")
    val ratingVoteCount: Int,
    @SerializedName("year")
    val year: String
)