package com.example.moviedb.ui.genre


import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.example.moviedb.R
import com.example.moviedb.databinding.FragmentGenreBinding
import com.example.moviedb.ui.adapter.MovieAdapter
import com.example.moviedb.ui.base.BaseFragment
import com.example.moviedb.ui.base.EndlessRecyclerOnScrollListener
import com.example.moviedb.ui.genre.GenreViewModel.TypeLoad.LOAD_MORE
import com.example.moviedb.ui.genre.GenreViewModel.TypeLoad.LOAD_NEW
import com.example.moviedb.utils.Constant

/**
 * A simple [Fragment] subclass.
 */
class GenreFragment : BaseFragment<FragmentGenreBinding>(),
    EndlessRecyclerOnScrollListener.OnLoadMore {
    private lateinit var genreViewModel: GenreViewModel

    private lateinit var keyGenre: String

    private val movieAdapter = MovieAdapter()

    override val layoutResourceId: Int
        get() = R.layout.fragment_genre

    override fun setupView() {
        genreViewModel = ViewModelProviders.of(this).get(GenreViewModel::class.java)

        genreViewModel.errorLiveData.observe(this, Observer {
            toast(it)
        })

        genreViewModel.loadingLiveData.observe(this, Observer {
            if (it == true) activity?.showLoadingDialog() else hideLoadingDialog()
        })

        mBinding.recyclerMovies.layoutManager = GridLayoutManager(activity, NUMBER_COLUMN)

        val endlessRecyclerOnScrollListener = EndlessRecyclerOnScrollListener(
            genreViewModel.isExhaust,
            mBinding.recyclerMovies.layoutManager as GridLayoutManager,
            this
        )

        mBinding.recyclerMovies.adapter = movieAdapter

        mBinding.recyclerMovies.setOnScrollListener(endlessRecyclerOnScrollListener)

        genreViewModel.moviesLiveData.observe(this, Observer {
            if (it.page == FIRST_PAGE) {
                movieAdapter.setMovies(it.movies)
                endlessRecyclerOnScrollListener.isExhaust = genreViewModel.isExhaust
            } else {
                movieAdapter.addMovies(it.movies)
            }
        })
    }

    override fun loadData() {
        val key = arguments?.getString(Constant.BUNDLE_KEY_FRAGMENT)
        val titleGenres = resources.getStringArray(R.array.title_genre)
        val keyGenres = resources.getStringArray(R.array.key_genre)
        keyGenre = keyGenres[titleGenres.indexOf(key)]
        genreViewModel.getMovies(keyGenre, FIRST_PAGE, LOAD_NEW)
    }


    override fun onLoadMore() {
        genreViewModel.getMovies(keyGenre, genreViewModel.currentPage, LOAD_MORE)
    }

    companion object {
        private const val NUMBER_COLUMN: Int = 2
        private const val FIRST_PAGE: Int = 1
    }
}
