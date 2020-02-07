package com.example.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.data.model.ProductionCompany
import com.example.moviedb.databinding.ItemManufactureBinding

class ManufactureAdapter(private val manufactures: List<ProductionCompany>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            DataBindingUtil.inflate<ItemManufactureBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_manufacture,
                parent,
                false
            )
        return CasterViewHolder(binding)
    }

    override fun getItemCount(): Int = manufactures?.size ?: 0


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        manufactures?.let {
            (holder as CasterViewHolder).bindData(it[position])
        }
    }

    class CasterViewHolder(val binding: ItemManufactureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(productionCompany: ProductionCompany) {
            binding.manufacture = productionCompany
        }
    }
}
