package com.example.moviedb.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    lateinit var mBinding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), layoutResourceId, container, false)
        setupView()
        loadData()
        return mBinding.root
    }

    abstract val layoutResourceId: Int

    abstract fun setupView()

    abstract fun loadData()

    fun toast(message: String) {
        activity ?: return
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}