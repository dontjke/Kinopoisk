package com.stepanov.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.stepanov.kinopoisk.R
import com.stepanov.kinopoisk.databinding.FragmentFilmDetailsBinding
import com.stepanov.kinopoisk.utils.KEY_BUNDLE_FILM
import com.stepanov.kinopoisk.viewmodel.filmdetails.FilmDetailsState
import com.stepanov.kinopoisk.viewmodel.filmdetails.FilmDetailsViewModel
import java.util.Locale

class FilmDetailsFragment : Fragment() {
    private var _binding: FragmentFilmDetailsBinding? = null
    private val binding: FragmentFilmDetailsBinding
        get() {
            return _binding!!
        }
    private val filmDetailsViewModel: FilmDetailsViewModel by lazy {
        ViewModelProvider(this)[FilmDetailsViewModel::class.java]
    }
    private var filmIdBundle: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmIdBundle = requireArguments().getInt(KEY_BUNDLE_FILM)

        val observer = { data: FilmDetailsState -> renderData(data) }
        filmDetailsViewModel.getLiveData().observe(viewLifecycleOwner, observer)
        filmDetailsViewModel.getFilm(filmIdBundle)
    }

    private fun renderData(data: FilmDetailsState) {
        when (data) {
            is FilmDetailsState.Error -> {
                binding.progressBar.visibility = View.GONE
                Snackbar.make(
                    binding.root,
                    data.error.message ?: getString(R.string.error),
                    Snackbar.LENGTH_LONG
                ).show()
            }

            is FilmDetailsState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }

            is FilmDetailsState.Success -> {
                binding.progressBar.visibility = View.GONE
                with(binding) {

                    posterImageView.load(data.filmDetails.posterUrl)
                    nameRuTextView.text = data.filmDetails.nameRu
                    descriptionTextView.text = data.filmDetails.description
                    val genres = data.filmDetails.genres.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                    }
                    (getString(R.string.genres) + genres).also { genresTextView.text = it }

                    (getString(R.string.countries) + data.filmDetails.countries).also {
                        countriesTextView.text = it
                    }
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            FilmDetailsFragment().apply {
                arguments = bundle
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}