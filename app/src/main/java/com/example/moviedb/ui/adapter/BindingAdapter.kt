package com.example.moviedb.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviedb.data.model.Caster
import com.example.moviedb.data.model.ProductionCompany
import com.example.moviedb.utils.ImageUtils


object BindingAdapter {

    @BindingAdapter("overview")
    @JvmStatic
    fun showOverview(textView: TextView?, overview: String?) {
        textView?.text = overview
    }

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(imageView: ImageView?, filename: String?) {
        imageView?.let {
            Glide.with(it.context).load(ImageUtils.getLink(filename)).into(it)
        }
    }

    @BindingAdapter("loadCircleImage")
    @JvmStatic
    fun loadCircleImage(imageView: ImageView?, filename: String?) {
        imageView?.let {
            Glide.with(it.context).load(ImageUtils.getLink(filename))
                .apply(RequestOptions().circleCrop()).into(it)
        }
    }

    @BindingAdapter("showCasters")
    @JvmStatic
    fun showCasters(recyclerView: RecyclerView?, casters: MutableList<Caster>?) {
        val casterAdapter = CasterAdapter(casters)
        recyclerView?.adapter = casterAdapter
    }

    @BindingAdapter("showManufacture")
    @JvmStatic
    fun showManufacture(
        recyclerView: RecyclerView?,
        productionCompanies: MutableList<ProductionCompany>?
    ) {
        val manufactureAdapter = ManufactureAdapter(productionCompanies)
        recyclerView?.adapter = manufactureAdapter
    }

    @BindingAdapter("rating")
    @JvmStatic
    fun setRating(textView: TextView?, vote: Float?) {
        textView?.text = vote.toString()
    }
}
