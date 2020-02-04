package com.example.moviedb.ui.dialog

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.moviedb.R

class LoadingDialog(context: Context) : Dialog(context, R.style.LoadingDialog) {
    init {

        val size = context.resources.getDimension(R.dimen.dp_80).toInt()
        val padding = context.resources.getDimension(R.dimen.dp_16).toInt()
        val progressBar = ProgressBar(context).apply {
            layoutParams = ViewGroup.LayoutParams(size, size)
            setPadding(padding, padding, padding, padding)
            isIndeterminate = true
        }

        setContentView(progressBar)
        setCancelable(true)
        setCanceledOnTouchOutside(false)
    }
}