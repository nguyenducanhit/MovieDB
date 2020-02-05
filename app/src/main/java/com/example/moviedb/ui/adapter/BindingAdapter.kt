package com.example.moviedb.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.utils.ImageUtils


object BindingAdapter {

    @BindingAdapter("manufacture")
    @JvmStatic
    fun showManufacture(textView: TextView?, manufacture: String?) {
        textView?.text = manufacture
    }

    @BindingAdapter("overview")
    @JvmStatic
    fun showOverview(textView: TextView?, overview: String?) {
        textView?.text = textView?.context?.getString(R.string.title_overview, overview)
    }

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(imageView: ImageView?, filename: String?) {
        imageView?.let {
            Glide.with(it.context).load(ImageUtils.getLink(filename)).into(it)
        }
    }

    @BindingAdapter("rating")
    @JvmStatic
    fun setRating(textView: TextView?, vote: Float?) {
        textView?.text = vote.toString()
    }
}
