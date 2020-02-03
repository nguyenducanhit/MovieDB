package com.example.moviedb.ui.genre

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.data.service.MoviesResponse
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import com.example.moviedb.ui.genre.GenreViewModel.TypeLoad.LOAD_MORE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class GenreViewModel : BaseViewModel() {
    private val movieRepository =
        MovieRepository.getInstance(RetrofitInstance.getInstance().create(ApiService::class.java))

    var isExhaust = false

    var currentPage: Int = 1

    private val compositeDisposable = CompositeDisposable()

    private val mutableLiveData = MutableLiveData<MoviesResponse>()

    fun getMovies(key: String, page: Int, typeLoad: Int) {
        currentPage = if (typeLoad == LOAD_MORE) page + 1 else page

        val disposable = movieRepository.getMovieByType(key, currentPage)
            .doOnSubscribe {
                loadingLiveData.postValue(true)
            }

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate {
                loadingLiveData.postValue(false)
            }
            .subscribe({
                mutableLiveData.postValue(it)
                isExhaust = it.page == it.totalPage
                currentPage = it.page
            }, {
                errorLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposable)
    }

    val moviesLiveData: MutableLiveData<MoviesResponse>
        get() = mutableLiveData

    object TypeLoad {
        const val LOAD_MORE = 1
        const val LOAD_NEW = 0
    }
}