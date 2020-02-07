package com.example.moviedb.ui.moviedetail

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.moviedb.R
import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.service.MovieDetailResponse
import com.example.moviedb.databinding.ActivityMovieDetailBinding
import com.example.moviedb.ui.base.BaseActivity

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding>() {

    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override val layoutResource: Int
        get() = R.layout.activity_movie_detail

    override fun loadData() {
        movieDetailViewModel.getMovie(intent.getIntExtra(EXTRA_MOVIE_ID, 0))
    }

    private fun showData(movie: MovieDetailResponse) {
        binding.movie = movie
    }

    override fun setupUI() {
        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)

        movieDetailViewModel.errorLiveData.observe(this, Observer {
            toast(it)
        })

        movieDetailViewModel.movieLiveData.observe(this, Observer {
            showData(it)
        })

        movieDetailViewModel.loadingLiveData.observe(this, Observer {
            if (it) {
                showLoadingDialog()
            } else {
                hideLoadingDialog()
            }
        })
    }

    companion object {
        fun start(context: Context, movieId: Int) {
            val intent =
                Intent(context, MovieDetailActivity::class.java).putExtra(EXTRA_MOVIE_ID, movieId)

            context.startActivity(intent)
        }

        private const val EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID"
    }
}
