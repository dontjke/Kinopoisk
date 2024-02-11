package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.repository.dto.FilmDetailsDTO
import com.stepanov.kinopoisk.repository.dto.TopDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskAPI {
    @GET("/api/v2.2/films/top")
    fun loadTopFilms(
        @Header("x-api-key") token: String,
        @Query("type") type: String
    ): Call<TopDTO>

    @GET("/api/v2.2/films/{id}")
    fun loadFilmDetails(
        @Header("x-api-key") token: String,
        @Path("id") id: Int
    ): Call<FilmDetailsDTO>
}