package com.stepanov.kinopoisk.repository.dto


import com.google.gson.annotations.SerializedName


data class FilmDetailsDTO(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("countries")
    val countries: List<CountryDTO>,
    @SerializedName("coverUrl")
    val coverUrl: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("editorAnnotation")
    val editorAnnotation: Any,
    @SerializedName("endYear")
    val endYear: Any,
    @SerializedName("filmLength")
    val filmLength: Int,
    @SerializedName("genres")
    val genres: List<GenreDTO>,
    @SerializedName("has3D")
    val has3D: Boolean,
    @SerializedName("hasImax")
    val hasImax: Boolean,
    @SerializedName("imdbId")
    val imdbId: String,
    @SerializedName("isTicketsAvailable")
    val isTicketsAvailable: Boolean,
    @SerializedName("kinopoiskHDId")
    val kinopoiskHDId: String,
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("lastSync")
    val lastSync: String,
    @SerializedName("logoUrl")
    val logoUrl: String,
    @SerializedName("nameEn")
    val nameEn: Any,
    @SerializedName("nameOriginal")
    val nameOriginal: String,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("productionStatus")
    val productionStatus: Any,
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String,
    @SerializedName("ratingAwait")
    val ratingAwait: Any,
    @SerializedName("ratingAwaitCount")
    val ratingAwaitCount: Int,
    @SerializedName("ratingFilmCritics")
    val ratingFilmCritics: Double,
    @SerializedName("ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int,
    @SerializedName("ratingGoodReview")
    val ratingGoodReview: Double,
    @SerializedName("ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int,
    @SerializedName("ratingImdb")
    val ratingImdb: Double,
    @SerializedName("ratingImdbVoteCount")
    val ratingImdbVoteCount: Int,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double,
    @SerializedName("ratingKinopoiskVoteCount")
    val ratingKinopoiskVoteCount: Int,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String,
    @SerializedName("ratingRfCritics")
    val ratingRfCritics: Any,
    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int,
    @SerializedName("reviewsCount")
    val reviewsCount: Int,
    @SerializedName("serial")
    val serial: Boolean,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("shortFilm")
    val shortFilm: Boolean,
    @SerializedName("slogan")
    val slogan: String,
    @SerializedName("startYear")
    val startYear: Any,
    @SerializedName("type")
    val type: String,
    @SerializedName("webUrl")
    val webUrl: String,
    @SerializedName("year")
    val year: Int
)