package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.repository.dto.TopDTO
import com.stepanov.kinopoisk.utils.KINOPOISK_END_POINT_TOP
import com.stepanov.kinopoisk.utils.KINOPOISK_HEADER_TOP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface KinopoiskAPI {
    @GET(KINOPOISK_END_POINT_TOP)
    fun loadTopFilms(
        @Header(KINOPOISK_HEADER_TOP) token: String
    ): Call<TopDTO>
}