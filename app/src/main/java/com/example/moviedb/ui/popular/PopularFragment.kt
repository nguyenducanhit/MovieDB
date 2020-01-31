package com.example.moviedb.ui.popular

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.moviedb.R
import com.example.moviedb.ui.base.BaseFragment
import com.example.moviedb.databinding.FragmentPopularBinding
import com.example.moviedb.ui.base.MovieAdapter

/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : BaseFragment<FragmentPopularBinding>() {

    lateinit var popularViewModel: PopularViewModel

    override fun setupView() {
        popularViewModel = ViewModelProviders.of(this).get(PopularViewModel::class.java)
        popularViewModel.movieResponseLiveData.observe(this, Observer {
            val adapter = MovieAdapter(it.movies)
            mBinding.recyclerMovies.adapter = adapter
        })

        popularViewModel.errorLiveData.observe(this, Observer(::toast))
    }

    override fun loadData() {
        popularViewModel.getMovies(1)
    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_popular
}
