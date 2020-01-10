package com.example.moviedb.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.moviedb.R
import com.example.moviedb.base.BaseFragment
import com.example.moviedb.databinding.FragmentPopularBinding

/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : BaseFragment<FragmentPopularBinding>() {

    override fun getLayoutResourceId() = R.layout.fragment_popular
}
