package com.stepanov.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.stepanov.kinopoisk.R
import com.stepanov.kinopoisk.databinding.FragmentFilmsBinding
import com.stepanov.kinopoisk.utils.KEY_BUNDLE_FILM
import com.stepanov.kinopoisk.view.adapter.FilmsRecyclerViewAdapter
import com.stepanov.kinopoisk.view.adapter.OnFilmClickListener
import com.stepanov.kinopoisk.viewmodel.films.AppState
import com.stepanov.kinopoisk.viewmodel.films.FilmsViewModel


class FilmsFragment : Fragment(), OnFilmClickListener {

    private var _binding: FragmentFilmsBinding? = null
    private val binding: FragmentFilmsBinding
        get() {
            return _binding!!
        }

    private val adapter = FilmsRecyclerViewAdapter(this)
    private val filmsViewModel: FilmsViewModel by lazy {
        ViewModelProvider(this)[FilmsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }

        val observer = { data: AppState -> renderData(data) }
        filmsViewModel.getLiveData().observe(viewLifecycleOwner, observer)
        filmsViewModel.getFilms()
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(
                    binding.root,
                    data.error.message ?: getString(R.string.error),
                    Snackbar.LENGTH_LONG
                ).show()
            }

            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }

            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                adapter.setData(data.filmsList)
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FilmsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(id: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FilmDetailsFragment.newInstance(Bundle().apply {
                putInt(KEY_BUNDLE_FILM, id)
            }))
            .addToBackStack("")
            .commit()
    }
}