package com.example.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.data.model.Caster
import com.example.moviedb.databinding.ItemCasterBinding

class CasterAdapter(private val casters: MutableList<Caster>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            DataBindingUtil.inflate<ItemCasterBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_caster,
                parent,
                false
            )
        return CasterViewHolder(binding)
    }

    override fun getItemCount(): Int = casters?.size ?: 0


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        casters?.let {
            (holder as CasterViewHolder).bindData(it[position])
        }
    }

    class CasterViewHolder(val binding: ItemCasterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(caster: Caster) {
            binding.caster = caster
        }
    }
}
