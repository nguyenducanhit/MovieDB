package com.example.moviedb.ui.popular

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.repository.MovieRepository
import com.example.moviedb.data.service.MoviesResponse
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularViewModel: BaseViewModel(){
    companion object{
        const val POPULAR_KEY = "popular"
    }
    val movieResponseLiveData = MutableLiveData<MoviesResponse>()
    private val movieRepository = MovieRepository.getInstance(RetrofitInstance.getInstance()!!.create(ApiService::class.java))
    private val compositeDisposable = CompositeDisposable()

    fun getMovies(page: Int){
        val disposable = movieRepository.getMovieByType(POPULAR_KEY, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieResponseLiveData.postValue(it)
            },{
                errorLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposable)
    }
}