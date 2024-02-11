package com.stepanov.kinopoisk.viewmodel.filmdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.kinopoisk.domain.FilmDetails
import com.stepanov.kinopoisk.repository.CallbackFilmDetails
import com.stepanov.kinopoisk.repository.DefaultFilmRepository
import com.stepanov.kinopoisk.repository.RemoteDataSource


class FilmDetailsViewModel(
    private val liveData: MutableLiveData<FilmDetailsState> = MutableLiveData(),
    private val defaultFilmRepository: DefaultFilmRepository = DefaultFilmRepository(
        RemoteDataSource()
    )
) : ViewModel(), CallbackFilmDetails {

    fun getLiveData() = liveData


    fun getFilm(id: Int) {
        liveData.postValue(FilmDetailsState.Loading)
        defaultFilmRepository.getFilmById(id, this)
    }

    override fun onResponse(filmDetails: FilmDetails) {
        liveData.postValue(FilmDetailsState.Success(filmDetails))
    }

    override fun onFailure(t: Throwable) {
        liveData.postValue(FilmDetailsState.Error(t))
    }
}