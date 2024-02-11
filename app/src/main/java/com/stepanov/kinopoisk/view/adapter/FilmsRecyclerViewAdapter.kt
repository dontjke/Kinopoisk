package com.stepanov.kinopoisk.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stepanov.kinopoisk.databinding.FragmentFilmRecyclerItemBinding
import com.stepanov.kinopoisk.domain.Film
import java.util.Locale

class FilmsRecyclerViewAdapter(
    private val onFilmClickListener: OnFilmClickListener,
    private var data: List<Film> = listOf()
) : RecyclerView.Adapter<FilmsRecyclerViewAdapter.FilmHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataNew: List<Film>) {
        this.data = dataNew
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val binding = FragmentFilmRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FilmHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(data[position])
    }


    inner class FilmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(film: Film) {
            FragmentFilmRecyclerItemBinding.bind(itemView).apply {
                genresViewRecyclerItem.text = film.genres.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                }


                nameViewRecyclerItem.text = film.nameRu
                "(${film.year})".also { yearViewRecyclerItem.text = it }
                imageViewRecyclerItem.load(film.posterUrlPreview)
                root.setOnClickListener {
                    onFilmClickListener.onItemClick(film.id)
                }
            }
        }
    }
}