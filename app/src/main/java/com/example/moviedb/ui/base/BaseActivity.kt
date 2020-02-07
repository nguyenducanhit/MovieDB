package com.example.moviedb.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.moviedb.ui.dialog.LoadingDialog

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: T

    private var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResource)
        loadingDialog = LoadingDialog(this)

        setupUI()
        loadData()
    }

    abstract val layoutResource: Int

    abstract fun loadData()

    abstract fun setupUI()

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    fun showLoadingDialog() {
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
