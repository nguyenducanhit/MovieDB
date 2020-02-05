package com.example.moviedb.ui.moviedetail

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel : BaseViewModel() {
    private val movieRepository =
        MovieRepository.getInstance(RetrofitInstance.getInstance().create(ApiService::class.java))

    private val compositeDisposable = CompositeDisposable()

    val movieLiveData = MutableLiveData<Movie>()

    fun getMovie(id: Int) {
        val disposable = movieRepository.getMovie(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieLiveData.postValue(it)
            }, {
                errorLiveData.postValue(it.message)
            })

        compositeDisposable.add(disposable)
    }
}
