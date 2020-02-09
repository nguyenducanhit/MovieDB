package com.example.moviedb.ui.moviedetail

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.data.service.MovieDetailResponse
import com.example.moviedb.data.service.TrailerResponse
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel : BaseViewModel() {
    private val movieRepository =
        MovieRepository.getInstance(RetrofitInstance.getInstance().create(ApiService::class.java))

    private val compositeDisposable = CompositeDisposable()

    val movieLiveData = MutableLiveData<MovieDetailResponse>()

    fun getMovie(id: Int) {
        val movieDetail: Single<MovieDetailResponse> = movieRepository.getMovie(id)
        val trailer: Single<TrailerResponse> = movieRepository.getTrailer(id)
        val biFunction =
            BiFunction<MovieDetailResponse, TrailerResponse, MovieDetailResponse>({ movieDetailResponse, trailerResponse ->
                setTrailer(movieDetailResponse, trailerResponse)
            })

        val disposable =
            Observable.zip(movieDetail.toObservable(), trailer.toObservable(), biFunction)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    loadingLiveData.postValue(true)
                }
                .doOnTerminate {
                    loadingLiveData.postValue(false)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieLiveData.postValue(it)
                }, {
                    errorLiveData.postValue(it.message)
                })
        compositeDisposable.add(disposable)
    }

    fun setTrailer(
        movieDetailResponse: MovieDetailResponse,
        trailerResponse: TrailerResponse
    ): MovieDetailResponse {
        movieDetailResponse.trailer = trailerResponse.trailers[0].key
        return movieDetailResponse
    }
}
