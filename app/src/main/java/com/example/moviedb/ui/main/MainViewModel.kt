package com.example.moviedb.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.model.Genre
import com.example.moviedb.data.repository.GenreRepository
import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.service.api.RetrofitInstance
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel() {
    val mutableLiveData = MutableLiveData<List<Genre>>()
    private val repository by lazy { GenreRepository.getInstance(RetrofitInstance.getInstance().create(ApiService::class.java)) }
    private val compositeDisposable = CompositeDisposable()
    fun getGenres() {
        val disposables = repository.getGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableLiveData.postValue(it)
            }, {
                errorLiveData.postValue(it.message)
            })
        compositeDisposable.add(disposables)
    }
}
