package com.stepanov.kinopoisk.repository

import com.stepanov.kinopoisk.repository.dto.FilmDetailsDTO
import com.stepanov.kinopoisk.repository.dto.TopDTO
import com.stepanov.kinopoisk.utils.KINOPOISK_API_KEY
import com.stepanov.kinopoisk.utils.KINOPOISK_API_TYPE
import com.stepanov.kinopoisk.utils.KINOPOISK_BASE_URL
import com.stepanov.kinopoisk.utils.REQUEST_ERROR
import com.stepanov.kinopoisk.utils.SERVER_ERROR
import com.stepanov.kinopoisk.utils.toFilm
import com.stepanov.kinopoisk.utils.toFilmDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    private val kinopoiskAPI: KinopoiskAPI = Retrofit.Builder().apply {
        baseUrl(KINOPOISK_BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
    }.build().create(KinopoiskAPI::class.java)


    fun getFilms(callback: CallbackFilms) {
        kinopoiskAPI.loadTopFilms(KINOPOISK_API_KEY, KINOPOISK_API_TYPE)
            .enqueue(object : Callback<TopDTO> {
                override fun onResponse(call: Call<TopDTO>, response: Response<TopDTO>) {

                    val serverResponse: TopDTO? = response.body()
                    if (response.isSuccessful && serverResponse != null) {
                        val filmsList = serverResponse.films.map {
                            it.toFilm()
                        }
                        callback.onResponse(filmsList)
                    } else {
                        callback.onFailure(Throwable(REQUEST_ERROR))
                    }
                }

                override fun onFailure(call: Call<TopDTO>, t: Throwable) {
                    callback.onFailure(Throwable(SERVER_ERROR))
                }
            })
    }

    fun getFilmDetails(id: Int, callback: CallbackFilmDetails) {
        kinopoiskAPI.loadFilmDetails(KINOPOISK_API_KEY, id)
            .enqueue(object : Callback<FilmDetailsDTO> {
                override fun onResponse(
                    call: Call<FilmDetailsDTO>,
                    response: Response<FilmDetailsDTO>
                ) {
                    val serverResponse: FilmDetailsDTO? = response.body()
                    if (response.isSuccessful && serverResponse != null) {
                        val film = serverResponse.toFilmDetails()
                        callback.onResponse(film)
                    }
                }

                override fun onFailure(call: Call<FilmDetailsDTO>, t: Throwable) {
                    callback.onFailure(Throwable(SERVER_ERROR))
                }
            })
    }
}
