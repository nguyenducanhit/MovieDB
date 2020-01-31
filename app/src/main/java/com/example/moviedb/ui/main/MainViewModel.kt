package com.example.moviedb.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data.model.Genre
import com.example.moviedb.data.repository.GenreRepository
import com.example.moviedb.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel() {
    val mutableLiveData = MutableLiveData<List<Genre>>()
    val repository = GenreRepository.getInstance()
    fun getGenres() {
        val disposables = repository.getGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableLiveData.postValue(it)
            }, {
                errorLiveData.postValue(it.message)
            })
    }
}