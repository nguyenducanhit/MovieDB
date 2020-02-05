package com.example.moviedb.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.moviedb.ui.dialog.LoadingDialog

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    lateinit var binding: T

    private var loadingDialog: LoadingDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(activity),
            layoutResourceId,
            container,
            false
        )
        loadingDialog = context?.let {
            LoadingDialog(it)
        }
        setupView()
        loadData()
        return binding.root
    }

    abstract val layoutResourceId: Int

    abstract fun setupView()

    abstract fun loadData()

    fun toast(message: String) {
        activity ?: return
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }


    fun Activity.showLoadingDialog() {
        loadingDialog?.let {
            runOnUiThread(Runnable {
                if (isFinishing) {
                    return@Runnable
                }
                it.show()
            })
        }
    }

    fun hideLoadingDialog() {
        loadingDialog?.dismiss()
    }
}
