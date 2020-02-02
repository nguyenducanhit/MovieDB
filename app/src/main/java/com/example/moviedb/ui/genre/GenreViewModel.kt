package com.example.moviedb.ui.genre

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.data.service.MoviesResponse
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GenreViewModel : BaseViewModel() {
    private val movieRepository =
        MovieRepository.getInstance(RetrofitInstance.getInstance().create(ApiService::class.java))

    private val compositeDisposable = CompositeDisposable()

    val mutableLiveData = MutableLiveData<MoviesResponse>()

    fun getMovies(key: String) {
        val disposable = movieRepository.getMovieByType(key, FIRST_PAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableLiveData.postValue(it)
            }, {
                errorLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposable)
    }

    companion object {
        private const val FIRST_PAGE: Int = 1
    }
}