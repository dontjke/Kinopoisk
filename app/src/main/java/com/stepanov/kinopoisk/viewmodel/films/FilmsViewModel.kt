package com.stepanov.kinopoisk.viewmodel.films

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.kinopoisk.domain.Film
import com.stepanov.kinopoisk.repository.CallbackFilms
import com.stepanov.kinopoisk.repository.DefaultFilmRepository
import com.stepanov.kinopoisk.repository.RemoteDataSource


class FilmsViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val defaultFilmRepository: DefaultFilmRepository = DefaultFilmRepository(
        RemoteDataSource()
    )
) : ViewModel(), CallbackFilms {

    fun getLiveData() = liveData

    fun getFilms() {
        liveData.postValue(AppState.Loading)
        defaultFilmRepository.getFilmsFromServer(this)
    }

    override fun onResponse(filmsList: List<Film>) {
        liveData.postValue(AppState.Success(filmsList))
    }

    override fun onFailure(t: Throwable) {
        liveData.postValue(AppState.Error(t))
    }


}
