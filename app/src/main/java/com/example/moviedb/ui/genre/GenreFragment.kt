package com.example.moviedb.ui.genre


import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.example.moviedb.R
import com.example.moviedb.databinding.FragmentGenreBinding
import com.example.moviedb.ui.adapter.MovieAdapter
import com.example.moviedb.ui.base.BaseFragment
import com.example.moviedb.ui.utils.Constant

/**
 * A simple [Fragment] subclass.
 */
class GenreFragment : BaseFragment<FragmentGenreBinding>() {
    private lateinit var genreViewModel: GenreViewModel

    override fun setupView() {
        genreViewModel = ViewModelProviders.of(this).get(GenreViewModel::class.java)

        genreViewModel.errorLiveData.observe(this, Observer {
            toast(it)
        })

        genreViewModel.mutableLiveData.observe(this, Observer {
            mBinding.recyclerMovies.apply {
                layoutManager = GridLayoutManager(activity, NUMBER_COLLUMN)
                adapter = MovieAdapter(it.movies)
            }
        })
    }

    override fun loadData() {
        val key = arguments?.getString(Constant.BUNDLE_KEY_FRAGMENT)
        val titleGenres = resources.getStringArray(R.array.title_genre)
        val keyGenres = resources.getStringArray(R.array.key_genre)
        genreViewModel.getMovies(keyGenres.get(titleGenres.indexOf(key)))
    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_genre

    companion object {
        private const val NUMBER_COLLUMN: Int = 2
    }
}
