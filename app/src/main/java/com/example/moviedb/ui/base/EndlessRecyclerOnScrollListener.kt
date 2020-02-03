package com.example.moviedb.ui.base

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class EndlessRecyclerOnScrollListener(
    var isExhaust: Boolean,
    val gridLayoutManager: GridLayoutManager,
    val onLoadMore: OnLoadMore
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = recyclerView.childCount
        val totalItemCount = gridLayoutManager.itemCount
        val lastVisibleItem = gridLayoutManager.findFirstVisibleItemPosition()
        if (!isExhaust && visibleItemCount + lastVisibleItem >= totalItemCount){
            onLoadMore.onLoadMore()
        }
    }

    interface OnLoadMore{
        fun onLoadMore()
    }
}